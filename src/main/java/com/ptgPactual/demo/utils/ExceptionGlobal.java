package com.ptgPactual.demo.utils;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ptgPactual.demo.dto.ResponseFailDto;

@ControllerAdvice
public class ExceptionGlobal {
	
	@ExceptionHandler(PtgExceptionHandler.class)
    public ResponseEntity<ResponseFailDto> handleProductNotFoundException(PtgExceptionHandler ex) {
		 ResponseFailDto prestamoResponseFailDto =new ResponseFailDto();		 
		 prestamoResponseFailDto.setMensaje(ex.getMessage());
        return new ResponseEntity<ResponseFailDto>(prestamoResponseFailDto, HttpStatus.BAD_REQUEST);
    }

}
