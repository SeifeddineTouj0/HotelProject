package igl.projet.hotel.service;

import igl.projet.hotel.model.Room;
import igl.projet.hotel.payload.request.RoomRequest;
import igl.projet.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Value("${upload.directory}")
    private String uploadDirectory;


    @Override
    public Room createRoom(RoomRequest roomRequest) throws IOException {

       /* System.out.println(roomRequest);
        //Image saving
        MultipartFile imageFile= roomRequest.getImage();
        String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
        if (!Files.exists(Path.of(uploadDirectory))) {
            Files.createDirectories(Path.of(uploadDirectory));
        }
        String filePath = uploadDirectory + File.separator + fileName;
        File destFile = new File(filePath);
        imageFile.transferTo(destFile);
 */
        Room room = new Room();
        room.setView(roomRequest.getView());
        room.setPrice(roomRequest.getPrice());
        room.setCapacity(roomRequest.getCapacity());
        room.setName(roomRequest.getName());
        room.setDescription(roomRequest.getDescription());
       // room.setImageUrl(fileName);

        roomRepository.save(room);

        return room;
    }

    @Override
    public Room editRoom(RoomRequest roomRequest) {

        Room room = new Room();
        room.setId(roomRequest.getId());
        room.setView(roomRequest.getView());
        room.setPrice(roomRequest.getPrice());
        room.setCapacity(roomRequest.getCapacity());
        room.setName(roomRequest.getName());
        room.setDescription(roomRequest.getDescription());
        // room.setImageUrl(fileName);

        roomRepository.save(room);
        return room;
    }



    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
    @Override
    public Optional<Room> getRoom(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public List<Room> getAvailableReservations(String startDate, String endDate) {
        Date startDateFormat = null;
        Date endDateFormat = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            startDateFormat = dateFormat.parse(startDate);
            endDateFormat = dateFormat.parse(endDate);
        } catch (ParseException e) {
            // Handle parsing exception
            e.printStackTrace();
        }
        return roomRepository.findAvailableRooms( startDateFormat,  endDateFormat);
    }
}
