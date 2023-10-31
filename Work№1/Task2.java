// // Автотест задача 2 -  Разность двух массивов
// Реализуйте метод subArrays, принимающий в качестве аргументов два целочисленных массива a и b, и возвращающий новый массив c, 
//каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.

// Если длины массивов не равны - верните нулевой массив длины 1.

// Напишите свой код в методе subArrays класса Answer. Метод subArrays принимает на вход два параметра:

//     int[] a - первый массив
//     int[] b - второй массив

// Пример

// a = new int[]{4, 5, 6};
// b = new int[]{1, 2, 3};

// Вывод: [3, 3, 3]

// a = new int[]{4, 5, 6};
// b = new int[]{1, 2, 3, 5};

// Вывод: [0]

import java.util.Arrays;

public class Task2 
{
    public static void main(String[] args) { 
        int[] a = {};
        int[] b = {};
        
        if (args.length == 0) {
          // При отправке кода на Выполнение, вы можете варьировать эти параметры
          a = new int[]{4, 5, 6};
          b = new int[]{1, 2, 5};
        }
        else{
          a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
          b = Arrays.stream(args[1].split(", ")).mapToInt(Integer::parseInt).toArray();
        }     
        
        Task2 ans = new Task2(); 
        String itresume_res = Arrays.toString(ans.subArrays(a, b));     
        System.out.println(itresume_res);
      }

      public int[] subArrays(int[] a, int[] b)
    {
      // Введите свое решение ниже
      try
        {
            int[] resArray = new int[a.length];
            for(int i = 0; i < resArray.length; i++ )
            {
                resArray[i] = a[i] - b[i];
            }      
            return resArray;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return new int[]{0};
        }
          // if (a.length != b.length) {
  //         int[] emptyArray = new int[1];
  //         return emptyArray;
  //     }
      
  //     int[] resArray = new int[a.length];
  //     for (int i = 0; i < resArray.length; i++) {
  //         resArray[i] = a[i] / b[i];
  //     }
      
  //     return resArray;
    }
}


// Ответ бота


// public class Task2 
// {
//     public static void main(String[] args) { 
//         int[] a = {};
//         int[] b = {};
  
//         if (args.length == 0) {
//           a = new int[]{4, 5, 6};
//           b = new int[]{1, 2, 3};
//         }
//         else{
//           a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
//           b = Arrays.stream(args[1].split(", ")).mapToInt(Integer::parseInt).toArray();
//         }     
  
//         Task2 ans = new Task2(); 
//         String itresume_res = Arrays.toString(ans.subArrays(a, b));     
//         System.out.println(itresume_res);

//         public int[] subArrays(int[] a, int[] b){
//             if(a == null || b == null || a.length != b.length){
//                 return new int[1]; // нулевой массив длины 1 будет означать различие в длине массивов
//             }
//             else{
//                 int[] c = new int[a.length];
//                 for(int i = 0; i < a.length; i++){
//                     c[i] = a[i] - b[i];
//                 }
//                 return c;
//             }
//         }
// }