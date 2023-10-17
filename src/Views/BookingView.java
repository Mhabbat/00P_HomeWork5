package Views;
import Models.Table;
import Presenters.View;
import Presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;


public class BookingView implements View {

    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Отобразить столики на экране приложения
     *
     * @param tables коллекция столиков
     */
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    /**
     * Отобразить результат бронирования столика
     *
     * @param reservationNo номер бронирования
     */
    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Номер вашей брони: #%d\n", reservationNo);
        } else {
            System.out.println("Не удалось забронировать столик. Повторите попытку позже.");
        }
    }


    /**
     * Отобразить результат отмены бронирования столика
     *
     * @param oldReservation номер для отмены бронирования
     */
    @Override
    public void showCancelReservationTableResult(int oldReservation) {
        if (oldReservation > 0) {
            System.out.printf("Бронирование номер: #%d отменено.\n", oldReservation);
        } else {
            System.out.println("Нет такого бронирование");
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     *
     * @param orderDate дата бронирования
     * @param tableNo   номер столика
     * @param name      Имя
     */
    public void reservationTable(Date orderDate, int tableNo, String name) {
        if (observer != null)
            observer.onReservationTable(orderDate, tableNo, name);

    }

    /**
     * TODO: Доработать в рамках домашней работы
     * Действие клиента, отмена бронирования столика
     *
     * @param oldReservation  идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo         номер столика
     * @param name            Имя
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {

        if (observer != null)
            observer.changeReservationTable(oldReservation, reservationDate, tableNo, name);

    }


}