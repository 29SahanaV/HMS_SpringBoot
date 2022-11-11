package com.hms;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.hms.exception.globalException;
import com.hms.serviceimpl.userServiceImpl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HmswithspringApplicationTests {

	@Autowired
	private userServiceImpl service;

	@Disabled
	@Test
	void testDelete()throws globalException {

		var expected="deleted";
			var actual=service.deleteUser(2);
			assertSame(expected,actual);
	}

	@Disabled
	@Test
	void testphone()throws globalException{
		
		var expected="updated!...";
		var actual=service.updatePhone(1,"1212167890");
		assertSame(expected,actual);
	
	}

//	@Disabled
	@Test
	void testroom()throws globalException{
		
		var expected="Room Alloted to";
		var actual=service.allotRoom(1,101);
		assertSame(expected,actual);
	}
	@Disabled
	@Test
	void testFee()throws globalException{
		
		var expected="Fee Updated to";
		var actual=service.updateFee(1,6000);
		assertSame(expected,actual);
	}
	
}
