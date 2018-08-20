package mx.obolo.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import mx.obolo.model.Teapot;
import mx.obolo.service.TeapotService;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller(value = "/teapot")
public class TeapotController {

    private TeapotService teapotService;

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<Teapot> get() {
        return teapotService.getAll();
    }

    @Get(value = "{id}", produces = MediaType.APPLICATION_JSON)
    public Teapot get(@NotNull  Long id) {
        return teapotService.get(id);
    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Teapot save(@Body Teapot teapot) {
        return teapotService.save(teapot);
    }

    @Inject
    public void setTeapotService(TeapotService teapotService) {
        this.teapotService = teapotService;
    }
}
