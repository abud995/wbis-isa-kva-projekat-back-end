package wis.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import wis.domain.Address;
import wis.service.AddressService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService as;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Address>> getAddress() {
		return new ResponseEntity<Iterable<Address>>(as.getAddresses(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Address> addAddress(@RequestBody Address Address) {
		as.addAddress(Address);
		return new ResponseEntity<Address>(Address, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address Address) {
		as.updateAddress(id, Address);
		return new ResponseEntity<Address>(Address, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
		Optional<Address> Address = as.getAddressById(id);
		if(Address.isPresent()) {
			return new ResponseEntity<Address>(Address.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Address> removeAddress(@PathVariable Long id) {
		try {
			as.removeAddress(id);
		}catch (Exception e) {
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
	}
}
