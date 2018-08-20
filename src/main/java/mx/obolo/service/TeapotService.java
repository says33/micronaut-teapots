package mx.obolo.service;

import mx.obolo.model.Teapot;
import mx.obolo.repository.TeapotRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import java.util.List;

@Singleton
public class TeapotService {

    private TeapotRepository teapotRepository;

    public List<Teapot> getAll() {
        return teapotRepository.getAll();
    }

    public Teapot get(@NotNull  Long id) {
        return teapotRepository.findById(id);
    }

    public Teapot save(@NotNull Teapot teapot) {
        return teapotRepository.save(teapot);
    }

    @Inject
    public void setTeapotRepository(TeapotRepository teapotRepository) {
        this.teapotRepository = teapotRepository;
    }
}
