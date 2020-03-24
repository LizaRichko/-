package sample;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class  Zads {
    static Scanner in = new Scanner(System.in);


    /**
     * Визнвчити дату, яка наступить через певну кількість днів
     */
    static void zad1Rozr(TextField field, Label label) {
        int n = Integer.parseInt(field.getText());
        label.setText(String.valueOf(LocalDate.now().plusDays(n)));
    }


    /**
     * Показує кількість днів між датами
     */
    public static void Zad2(TextField SField, TextField EField, Label Condition, Label Answer) {
        LocalDate startDate = LocalDate.parse(SField.getText());
        LocalDate endtDate = LocalDate.parse(EField.getText());
        Long range = ChronoUnit.DAYS.between(startDate, endtDate);

        Condition.setText(SField.getText() + " - " + EField.getText());
        Answer.setText(String.valueOf(range) + " днів");

    }

    /**
     * Показує наступний день через введене восьмизначне число
     */
    public static void Zad3(TextField field, Label answer) {
        int date=Integer.parseInt(field.getText());
        int[] paramDate = new int[3];
        paramDate[0] = GiveYear(date);
        paramDate[1] = GiveMonth(date);
        paramDate[2] = GiveDay(date);

        switch (paramDate[1]) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(paramDate[2] < 32) {
                    if (paramDate[2] == 31) {
                        paramDate[1]++;
                        paramDate[2] = 1;
                    } else {
                        paramDate[2]++;
                    }

                    if (paramDate[1] == 13) {
                        paramDate[0]++;
                        paramDate[1] = 1;
                    }
                }
                else {
                    System.out.println("This day isn't found.");
                    return;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(paramDate[2] < 31) {
                    if (paramDate[2] == 30) {
                        paramDate[1]++;
                        paramDate[2] = 1;
                    } else {
                        paramDate[2]++;
                    }
                }
                else {
                    System.out.println("This day isn't found.");
                    return;
                }
                break;
            case 2:
                if(paramDate[0] % 4 == 0) {
                    if(paramDate[2] < 30) {
                        if (paramDate[2] == 29) {
                            paramDate[1]++;
                            paramDate[2] = 1;
                        } else {
                            paramDate[2]++;
                        }
                    }
                    else {
                        System.out.println("This day isn't found.");
                        return;
                    }
                }
                else {
                    if(paramDate[2] > 29) {
                        if (paramDate[2] == 28) {
                            paramDate[1]++;
                            paramDate[2] = 1;
                        } else {
                            paramDate[2]++;
                        }
                    }
                    else {
                        System.out.println("This day isn't found.");
                        return;
                    }
                }
            default:
                System.out.println("This month isn't found.");
                return;
        }

        String day = ((paramDate[2] < 10) ? "0" : "") + paramDate[2];
        String month = ((paramDate[1] < 10) ? "0" : "") + paramDate[1];
        String year = String.valueOf(paramDate[0]);

        answer.setText(day + "." + month + "." + year);
    }

    /**
     * Визначити кількість років в століччі (1900-2000), які починаються і закінчуються у неділю
     */
    public static void Zad4(TextField SField, TextField EField, Label result) {
        int n = 0;
        int startDate = Integer.parseInt(SField.getText());
        int endDate = Integer.parseInt(EField.getText());

        String day = "Sun";
        for(int i = startDate; i < endDate; i++) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.applyPattern("EEE, d MMM yyyy");
            String start = format.format(Date.parse("01/01/" + i));
            String end = format.format(Date.parse("01/01/" + i));
            if(start.startsWith(day) && end.startsWith(day)) {
                n++;
            }
        }

        result.setText(String.valueOf(n));
    }

    /**
     * Дана дата вашого дня народження (включаючи і день тижня).
     * Знайти ті дати, коли ваш день народження потрапить на той же день тижня
     */
    public static void Zad5(TextField dField, TextField mField, TextField yField, TextField dayField, Label result) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.applyPattern("EEE, d MMM yyyy");
        String start = format.format(Date.parse(dField.getText() + "/" + mField.getText() + "/" + yField.getText()));
        String day = dayField.getText();
        int n = 0;
        int year = Integer.valueOf(yField.getText());

        for (int i = year; i < year + 100; i++) {
            if(format.format(Date.parse(dField.getText() + "/" + mField.getText() + "/" + i)).startsWith(day))
                n++;
        }

        result.setText(String.valueOf(n));
    }

    private static int GiveYear(int n) {
        return n % 10000;
    }

    private static int GiveMonth(int n) {
        return ((n - GiveYear(n)) / 10000) % 100;
    }

    private static int GiveDay(int n) {
        return ((((n - GiveYear(n)) / 10000) - GiveMonth(n) ) / 100) % 100;
    }
}
