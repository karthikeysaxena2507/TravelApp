package travelApp.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import travelApp.entity.Package;
import travelApp.service.PackageService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PackageController.class)
class PackageControllerTest extends BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PackageService packageService;

    @Test
    void getAllPackages() throws Exception {

        Mockito.when(packageService.getAllPackages())
                .thenReturn(getPackageList());

        mockMvc.perform(
                        get("/packages")
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].packageName").value("Goa Tour"))
                .andExpect(jsonPath("$").isArray());

    }

    @Test
    void getPackageItinerary() {
    }

    @Test
    void getPassengersByPackage() {
    }

    @Test
    void getPackageByPackageName() {
    }

    @Test
    void addPackage() {
    }

    @Test
    void updatePackage() {
    }

    @Test
    void deletePackageByName() {
    }

    private List<Package> getPackageList() {
        Package packageItem = new Package();
        packageItem.setPackageName("Goa Tour");
        packageItem.setPassengerCapacity(10L);
        List<Package> packageList = new ArrayList<>();
        packageList.add(packageItem);
        return packageList;
    }
}