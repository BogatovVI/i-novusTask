package handler;

public interface CarNumberHandler {
    boolean searchCarNumber(String number);
    void addCarNumber(String number, Integer idUser);
    String searchLastUserCarNumber(Integer idUser);
}