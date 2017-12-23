package my.test.app1.controllers;

import my.test.app1.domain.OrderDto;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {


    private Logger log = LogManager.getLogger(this.getClass());
    private final TestService testService;

    private final TestComponent testComponent;

    @Autowired
    public OrderController(TestService service, TestComponent component) {
        testService = service;
        testComponent = component;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> getOrder(final @PathVariable String id) {
        log.debug(testComponent);
        log.debug(testService);
        log.debug(this);
        return new ResponseEntity<OrderDto>(
                new OrderDto("", null, Long.valueOf(id)), null, HttpStatus.OK);

    }


}
