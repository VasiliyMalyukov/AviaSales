package ru.netology.javaqamvn.domain;

public class AviaSales implements Comparable<AviaSales> {
    private int id;
    private int price;
    private int time;
    private String from; //из
    private String to; //куда

    public AviaSales() {
    }

    public AviaSales(int id, int price, int time, String from, String to) {
        this.id = id;
        this.price = price;
        this.time = time;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "AviaSales{" +
                "id=" + id +
                ", price=" + price +
                ", time=" + time +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

    @Override
    public int compareTo(AviaSales comparePrice) {
        return this.price - comparePrice.price;
    }
}