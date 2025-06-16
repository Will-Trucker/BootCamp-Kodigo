package adapter;

public class ThirdPartyAdapter {
    private ThirdPartyCarRental service;

    public ThirdPartyAdapter(ThirdPartyCarRental service) {
        this.service = service;
    }

    public void reserve(String car){
        service.bookCar(car);
    }

}
