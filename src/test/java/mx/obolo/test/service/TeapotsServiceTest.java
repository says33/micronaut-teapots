package mx.obolo.test.service;

import mx.obolo.model.Teapot;
import mx.obolo.repository.TeapotRepository;
import mx.obolo.service.TeapotService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TeapotsServiceTest {

    @Mock
    private TeapotRepository teapotRepository;

    @InjectMocks
    private TeapotService teapotService;

    @Test
    public void test() {
        List<Teapot> teapots = teapotService.getAll();
        assertNotNull(teapots);
    }

}
