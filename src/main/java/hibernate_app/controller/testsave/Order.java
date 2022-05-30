package hibernate_app.controller.testsave;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import hibernate_app.dto.ItemDto;
import hibernate_app.dto.MedOrderDto;
import hibernate_app.service.impl.MedOrderServiceImpl;

public class Order {
public static void main(String[] args) {
	MedOrderDto medOrderDto =new MedOrderDto();
	medOrderDto.setOrderTime(LocalDateTime.of(LocalDate.of(2022, 05, 28), LocalTime.now()));
	medOrderDto.setStatus("order placed");
	
	ItemDto itemDto = new ItemDto() ;
	itemDto.setName("PCT");
	itemDto.setCost(20);
	itemDto.setType("oral");
	itemDto.setMedOrderDto(medOrderDto);
	
	
	ItemDto itemDto1 = new ItemDto() ;
	itemDto1.setName("Dolo 650 ");
	itemDto1.setCost(18);
	itemDto1.setType("oral");
	itemDto1.setMedOrderDto(medOrderDto);
	
	ItemDto itemDto2 = new ItemDto() ;
	itemDto2.setName("CBD oil");
	itemDto2.setCost(500);
	itemDto2.setType("oil");
	itemDto2.setMedOrderDto(medOrderDto);
	
	List<ItemDto> items = new ArrayList<ItemDto>() ;
	items.add(itemDto) ;
	items.add(itemDto1) ;
	items.add(itemDto2) ;
	

	medOrderDto.setItems(items);
	
	MedOrderServiceImpl impl =  new MedOrderServiceImpl() ;
	impl.saveOrder(1, medOrderDto) ;
	
}
}
