package com.example.fire_department;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = FireDepartmentApplication.class)
class FireDepartmentApplicationTests {
    @Autowired
    private FireDepartmentApplication fireDepartmentApplication;

    @Test
    void contextLoads() {
        assertNotNull(fireDepartmentApplication);
    }

}
