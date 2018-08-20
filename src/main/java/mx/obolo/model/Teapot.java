package mx.obolo.model;

import java.io.Serializable;

public class Teapot implements Serializable {

    private Long id;
    private String name;
    private String teapotType;

    public static Teapot create(Long id, String name, String teapotType) {
        Teapot teapot = new Teapot();

        teapot.id = id;
        teapot.name = name;
        teapot.teapotType = teapotType;

        return teapot;
    }

    private Teapot() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeapotType() {
        return teapotType;
    }

    public void setTeapotType(String teapotType) {
        this.teapotType = teapotType;
    }
}
