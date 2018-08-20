package mx.obolo.repository;

import mx.obolo.exception.TeapotNotFound;
import mx.obolo.model.Teapot;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;


@Singleton
public class TeapotRepository {

    private static Queue<Teapot> dataSource = new ConcurrentLinkedQueue<>();

    public List<Teapot> getAll() {
        return new ArrayList<>(dataSource);
    }

    public Teapot findById(Long id) {
        return dataSource.stream()
            .filter(teapot -> teapot.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new TeapotNotFound("Not a teapot!"));
    }

    public Teapot save(Teapot teapot) {
        Teapot saved = Teapot.create(random(), teapot.getName(), teapot.getTeapotType());
        dataSource.add(saved);
        return saved;
    }

    private Long random() {
        return ThreadLocalRandom.current().nextLong(0, 100);
    }

}
