package com.uca.capas.formulario.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/ingresar")
	public ModelAndView ingresar() {
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("hora", Calendar.getInstance().getTime().toString());
		mav.setViewName("commons/ingresar");
		return mav;
	}
	
	
	@RequestMapping("/formulario")
	public ModelAndView ingresar(HttpServletRequest request) throws ParseException {
		ModelAndView mav= new ModelAndView();
		String nombre= request.getParameter("nombre");
		String apellido= request.getParameter("apellido");
		String fecha= request.getParameter("fecha");
		String lugar= request.getParameter("lugar");
		String cole= request.getParameter("cole");
		String telefono= request.getParameter("tel");
		String movil= request.getParameter("movil");
		
		List<String> error = new ArrayList();
		
		if (nombre.length() > 25 || nombre.length()==0) {
			
			error.add("Nombre debe tener minimo 1 carácter y maximo 25 caracteres. ");
			error.add("Actual: "+nombre+"- Cantidad de chars: "+nombre.length());
			error.add("------------------------------------------------------------------");
		}
		if (apellido.length() > 25 || apellido.length()==0) {
			
			error.add("Apellido debe tener minimo 1 carácter y maximo 25 caracteres."); 
			error.add("Actual: "+apellido+"- Cantidad de chars: "+apellido.length());
			error.add("------------------------------------------------------------------");
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //Para declarar valores en nuevos objetos date, usa el mismo formato date que usaste al crear las fechas 
		Date date1 = sdf.parse("2003-01-01"); 
		Date date2 = sdf.parse(fecha); 
		
		if(date1.compareTo(date2) < 0) {
			error.add("Fecha no puede ser mayor al 1 de enero de 2003. Actual: "+fecha);
			//System.out.println("Error esta fecha es menor a nuestro limite");
			error.add("------------------------------------------------------------------");
		}
		
		if (lugar.length() > 25 || lugar.length()==0) {
			
			error.add("Lugar de nacimiento debe tener minimo 1 carácter y maximo 25 caracteres.");
			error.add("Actual: "+lugar+"- Cantidad de chars: "+lugar.length());
			error.add("------------------------------------------------------------------");
		}
		
		if (cole.length() > 100 || cole.length()==0) {
			
			error.add("Institucion debe tener minimo 1 carácter y maximo 100 caracteres. Actual: "+cole+" Cantidad de chars:"+cole.length());
			error.add("Actual: "+cole+"- Cantidad de chars: "+cole.length());
			error.add("------------------------------------------------------------------");
		}
		
		if (telefono.length()!=8) {
			
			error.add("Telefono fijo debe tener 8 numeros exactamente.");
			error.add("Actual: "+telefono+"- Cantidad de chars:"+telefono.length());
			error.add("------------------------------------------------------------------");
		}
		
		if (movil.length()!=8) {
			
			error.add("Movil debe tener 8 numeros exactamente.");
			error.add("Actual: "+movil+"- Cantidad de chars:"+movil.length());
			error.add("------------------------------------------------------------------");
		}
		
		
		
		if(error.isEmpty()) {
			mav.setViewName("commons/exito");
			return mav;
			
		}else {
			System.out.println(error);
			mav.addObject("error", error);
			mav.setViewName("commons/resultado");
			return mav;
		}
		
		
		
		
		
		
		
		
	}
	

}
