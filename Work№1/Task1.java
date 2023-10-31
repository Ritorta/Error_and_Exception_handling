// Автотест задача 1 - Методы с исключениями

// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.

// Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива

// Метод divisionByZero - Деление на 0

// Метод numberFormatException - Ошибка преобразования строки в число

// Важно: они не должны принимать никаких аргументов

public class Task1 
{
    public static void main(String[] args) {
        Task1 ans = new Task1();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }

    public static void arrayOutOfBoundsException() {
        // Напишите свое решение ниже
        int[] array = new int[10];
        System.out.println(array[13]);

        
    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        int def = 10 / 0;
        System.out.println(def);
        
    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        String a = "abc";
        int num = Integer.parseInt(a);
        System.out.println(num);
       

    }

}



// Ответ от автотеста:

// public class Task1 
// {
//     public static void main(String[] args) {
//         Task1 ans = new Task1();
//         try {
//             ans.arrayOutOfBoundsException();
//         } catch (ArrayIndexOutOfBoundsException e) {
//             System.out.println("Выход за пределы массива");
//         }

//         try {
//             ans.divisionByZero();
//         } catch (ArithmeticException e) {
//             System.out.println("Деление на ноль");
//         }

//         try {
//             ans.numberFormatException();
//         } catch (NumberFormatException e) {
//             System.out.println("Ошибка преобразования строки в число");
//         }
//     }


//     public static void arrayOutOfBoundsException() {
//         int[] array = new int[10];
//         System.out.println(array[11]); // Выход за пределы массива
//     }

//     public static void divisionByZero() {
//         int a = 1;
//         int b = 0;
//         int c = a / b; // Деление на ноль
//     }

//     public static void numberFormatException() {
//         String str = "abc";
//         int num = Integer.parseInt(str); // Ошибка преобразования строки в число
//     }
// }