package home.investigation.rrr.fullstackappangularspringboot;

import home.investigation.rrr.fullstackappangularspringboot.entity.RoomEntity;
import home.investigation.rrr.fullstackappangularspringboot.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class H2Bootstrap implements CommandLineRunner {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrapping data: ");
        roomRepository.save(new RoomEntity(405, "117"));
        roomRepository.save(new RoomEntity(406, "107"));
        roomRepository.save(new RoomEntity(407, "98"));
        roomRepository.save(new RoomEntity(408, "119"));
        roomRepository.save(new RoomEntity(409, "129"));


        System.out.println("Printing out data: ");
        Iterable<RoomEntity> list = roomRepository.findAll();

        list.forEach(e -> System.out.println(e.getPrice()));
    }

}
