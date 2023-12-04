package ru.java.basic.penkin.hw8;

public class Main {         // В гитхаб vetka1
    public static void main(String[] args) {
        String[][] array = {
                {"41", "72", "65", "41"},
                {"32", "текст вместо числа", "62", "45"},   // Если в ячейке с текстом указать число, то массив преобразуется в int и суммируется.
                {"87", "68", "25", "37"},                   // Если изменить размер массива, то будет появится сообщение об ошибке: Неверный размер массива.
                {"29", "15", "56", "89"}
        };

        try {
            int sum = sumArrayElements(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (AppArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (AppArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int sumArrayElements(String[][] array) throws AppArraySizeException, AppArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new AppArraySizeException("Неверный размер массива");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int num = Integer.parseInt(array[i][j]);
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }
}

class AppArraySizeException extends Exception {
    public AppArraySizeException(String message) {
        super(message);
    }
}

class AppArrayDataException extends Exception {
    public AppArrayDataException(String message) {
        super(message);
    }
}