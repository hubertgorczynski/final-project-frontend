package com.carRental.views.car;

import com.carRental.client.RentalClient;
import com.carRental.domain.RentalComplexDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RentalView extends VerticalLayout {

    private final Grid<RentalComplexDto> rentalGrid = new Grid<>(RentalComplexDto.class);
    private final RentalClient rentalClient;

    @Autowired
    public RentalView(RentalClient rentalClient) {
        this.rentalClient = rentalClient;

        Button addRentalButton = new Button("Add new rental");

        rentalGrid.setColumns(
                "id",
                "rentedFrom",
                "rentedTo",
                "rentalCost",
                "carBrand",
                "carModel",
                "userName",
                "userLastName",
                "userEmail",
                "userPhoneNumber");

        List<RentalComplexDto> rentals = rentalClient.getRentals();
        rentalGrid.setItems(rentals);

        add(addRentalButton, rentalGrid);
    }
}
