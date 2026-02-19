package com.alpha.FoodDeliveryExpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.FoodDeliveryExpress.dto.DeliveryPartnerDto;
import com.alpha.FoodDeliveryExpress.entity.DeliveryPartner;
import com.alpha.FoodDeliveryExpress.repository.DeliveryPartnerRepository;

@Service
public class DeliveryPartnerService {

    @Autowired
    private DeliveryPartnerRepository deliveryPartnerRepository;


    public void adding(DeliveryPartnerDto deliveryPartnerDto) {
        DeliveryPartner deliveryPartner=new DeliveryPartner();
        deliveryPartner.setName(deliveryPartnerDto.getName());
        deliveryPartner.setMobno(deliveryPartnerDto.getMobno());
        deliveryPartner.setEmail(deliveryPartnerDto.getEmail());
        deliveryPartner.setVehicleNo(deliveryPartnerDto.getVehicleNo());
        deliveryPartnerRepository.save(deliveryPartner);
    }


	public void deletePartner(long mobno) {
		DeliveryPartner d= deliveryPartnerRepository.findByMobno(mobno).orElseThrow(()->new RuntimeException("DeliveryPartner not found"));
        deliveryPartnerRepository.delete(d);
		
	}


	public DeliveryPartner findDeliveryPartner(long mobno) {
		 return deliveryPartnerRepository.findByMobno(mobno).orElseThrow(()->new RuntimeException("DeliveryPartner not found"));
	}




}
