package igl.projet.hotel.service;

import igl.projet.hotel.model.Availability;
import igl.projet.hotel.repository.AvailabilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityServiceImpl implements AvailabilityService{

    @Autowired
    private AvailabilityRepo availabilityRepo;

    @Override
    public Availability createAvailability(Availability availability) {
        return availabilityRepo.save(availability);
    }

    @Override
    public Availability editAvailability(Availability availability) {
        return availabilityRepo.save(availability);
    }

    @Override
    public void deleteAvailability(Long id) {
        availabilityRepo.deleteById(id);
    }
}
