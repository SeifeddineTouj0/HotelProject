package igl.projet.hotel.service;

import igl.projet.hotel.model.Room;
import igl.projet.hotel.payload.request.RoomRequest;
import igl.projet.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

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
       // room.setImageUrl(fileName);

        roomRepository.save(room);

        return room;
    }
}
