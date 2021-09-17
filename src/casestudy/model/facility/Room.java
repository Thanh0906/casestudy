package casestudy.model.facility;

public class Room extends Facility {

    private String freeService;//dịch vụ miễn phí



    public Room(String idService, String nameService, double useArea, double rentalCosts,
                int numberPeople, String styleRental, String freeService) {
        super(idService, nameService, useArea, rentalCosts, numberPeople, styleRental);
        this.freeService = freeService;
    }


    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" + super.toString()+
                "freeService='" + freeService + '\'' +
                '}';
    }
    public String getToString(){
        return this.getIdService()+","+this.getNameService()+","+this.getUseArea()+","+this.getRentalCosts() +","+this.getNumberPeople()+","+this.getStyleRental() +","+this.getFreeService();
    }
}
