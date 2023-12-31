// Work №3: Урок 3. Продвинутая работа с исключениями в Java

// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
// Фамилия Имя Отчество датарождения номертелефона пол
// Форматы данных:
// фамилия, имя, отчество - строки
// датарождения - строка формата dd.mm.yyyy
// номертелефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.

// 1. Приложение должно проверить введенные данные по количеству. 
// Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

// 2. Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
// Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

// 3. Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
// <Фамилия><Имя><Отчество><датарождения><номертелефона><пол>
// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
// Не забудьте закрыть соединение с файлом.

// 4. При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        // Create scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the data in format: SurName, FirstName, Patronymic, Date of birth, Phone Number, You gender: M or F");
        String inputScanner = scanner.nextLine();
        //Check userData to 6
        try {
            // Split string
            String[] userData = inputScanner.trim().split(" ");
            // Cheak to correct number of fields
            if (userData.length != 6) 
            {
                throw new IllegalArgumentException
                ("The incorrect number of fields is filled in, please fill in the correct number of fields, which should not exceed six or be less than six.");
            }
            // Add userData
            String SurName = userData[0];
            String FirstName = userData[1];
            String Patronymic = userData[2];
            String birthDate = userData[3];
            // String phoneNumber = userData[4];
            long phoneNumber = Long.parseLong(userData[4]);
            // String gender = userData[5];
            char gender = userData[5].charAt(0);
            //Check validate userData
            validateUserData(SurName, FirstName, Patronymic, birthDate, phoneNumber, gender);
            //Record userData
            recUserData(SurName, FirstName, Patronymic, birthDate, phoneNumber, gender);

            System.out.println("User Data Successfully Saved");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("Error: Record or Read file");
            e.printStackTrace();
        }
        finally
        {
            scanner.close();
        }
    }
    // Validate UserData
    private static void validateUserData(String SurName, String FirstName, String Patronymic, String birthDate, long phoneNumber, char gender)
    {
        // Validate SurName
        if(!SurName.matches("[a-zA-Z]+"))
        {
            throw new IllegalArgumentException("Incorrect SurName");
        }
        // Validate FirstName
        if(!FirstName.matches("[a-zA-Z]+"))
        {
            throw new IllegalArgumentException("Incorrect FirstName");
        }
        // Validate Patronymic
        if(!Patronymic.matches("[a-zA-Z]+"))
        {
            throw new IllegalArgumentException("Incorrect Patronymic");
        }
        // Validate birthDate
        if(!birthDate.matches("\\d{2}.\\d{2}.\\d{4}"))
        {
            throw new IllegalArgumentException("Date format incorrectly");
        }
        
        String[] datePars = birthDate.split("\\.");
        int day = Integer.parseInt(datePars[0]);
        int month = Integer.parseInt(datePars[1]);

        if (day < 1 || day > 31 || month < 1 || month > 12) 
        {
            throw new IllegalArgumentException("Date values are incorrect");
        }
        // Validate phoneNumber (String)
        // if(!phoneNumber.matches("^\\+(\\d{1,3}(\\(\\d{1,3}\\))?)(?:[0-9] ?){6,14}[0-9]$"))
        // {
        //     throw new IllegalArgumentException("Incorrect Phone Number");
        // }
        // Validate phoneNumber (long)
        if (phoneNumber < 70000000000L || phoneNumber > 79999999999L) 
        {
            throw new IllegalArgumentException("Incorrect Phone Number. The phone number should be within the range of +70000000000 to +79999999999.");
        }
        // Validate gender (String)
        // if(!gender.matches("(?i)^(m|f|male|female)$"))
        // {
        //     throw new IllegalArgumentException("Incorrect gender");
        // }
        // Validate gender (Char)
        if(!String.valueOf(gender).equalsIgnoreCase("f") && !String.valueOf(gender).equalsIgnoreCase("m"))
        {
            throw new IllegalArgumentException("Incorrect gender");
        }
    }
    // Record Data
    private static void recUserData(String SurName, String FirstName, String Patronymic, String birthDate, long phoneNumber, char gender) throws IOException
    {
        // Create fille
        String newFile = SurName + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile, true)))
        {
            writer.write("SurName: " + SurName + ", FirstName: " + FirstName + ", Patronymic: " + Patronymic + 
            ",  Date of birth: " + birthDate + ", Phone Number: " + phoneNumber + ", Gender: " + gender + ";" + "\n");
        }
    }
}