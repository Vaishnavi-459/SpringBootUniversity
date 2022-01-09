package com.University.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.University.UniversityApplication;
import com.University.exception.ResourceNotFoundException;
import com.University.model.Address;
import com.University.repository.AddressRepository;

@RestController
@RequestMapping("/api/v1")
public class AddressController {
	private static final Logger logger = LoggerFactory.getLogger(UniversityApplication.class);
	@Autowired
	private AddressRepository addressRepository;

	// create get all address
	@GetMapping("/address")
	public List<Address> getAllAddress() {
		logger.info("getting All Address details");
		return addressRepository.findAll();

	}

	// get address by id
	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddressId(@PathVariable(value = "id") Long addressId)
			throws ResourceNotFoundException {
		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException("address not found on this id:: " + addressId));
		logger.info("getting the address, Id:" + addressId);
		return ResponseEntity.ok().body(address);
	}

	// save address
	@PostMapping("/address")
	public Address createAddress(@RequestBody Address address) {
		logger.info("creating an address");
		return addressRepository.save(address);
	}

	// update address
	@PutMapping("/address/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable(value = "id") Long addressId,
			@RequestBody Address addressDetails) throws ResourceNotFoundException {
		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException("Address not found on this id:: " + addressId));
		//logger.error("address not found ");

		address.setHouseNo(addressDetails.getHouseNo());
		address.setStreet(addressDetails.getStreet());
		address.setLocality(addressDetails.getLocality());
		address.setArea(addressDetails.getArea());
		address.setState(addressDetails.getState());
		address.setCountry(addressDetails.getCountry());
		address.setPin(addressDetails.getPin());

		final Address updatedAddress = addressRepository.save(address);
		logger.info("updating the address, Id:" + addressId);
		return ResponseEntity.ok(updatedAddress);

	}

	// delete address by id
	@DeleteMapping("/address/{id}")
	public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") Long addressId) throws Exception {
		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException("address not found on :: " + addressId));

		addressRepository.delete(address);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		logger.info("deleting the address, Id:" + addressId);
		return response;
	}
}
