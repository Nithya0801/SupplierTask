package com.niit.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.SupplierDao;
import com.niit.Model.Supplier;

@Controller
public class HomeController {
	
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("/")
	public ModelAndView index()
	{
		return new ModelAndView("index");
	}

	
	@RequestMapping("/index")
	public ModelAndView index1()
	{
		return new ModelAndView("index");
	}

	@RequestMapping("/insert")
	public ModelAndView insert()
	{
		return new ModelAndView("insert");
	}
	
	@RequestMapping("/insertData")
	public ModelAndView insertData(HttpServletRequest request)
	{
		Supplier supplier=new Supplier();
		int sid=Integer.parseInt(request.getParameter("sid"));
		supplier.setSid(sid);
		supplier.setSname(request.getParameter("sname"));
		
		boolean b=supplierDao.insertSupplier(supplier);
		
		if(b)
		return new ModelAndView("success");
		else
			return new ModelAndView("error");
	}
	
	@RequestMapping("/view")
	public ModelAndView viewData(HttpServletRequest request)
	{
		List<Supplier> l=supplierDao.getAll();
		request.getSession().setAttribute("obj", l);
		return new ModelAndView("view","l",l);
	}
	
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request)
	{
		int i=Integer.parseInt(request.getParameter("sid"));
		//request.getSession().setAttribute("sid",i);
		Supplier supplier=supplierDao.getSupplierById(i);
		request.getSession().setAttribute("supplier",supplier);
		return new ModelAndView("update");
	}
	
	@RequestMapping("/updateAll")
	public ModelAndView updateAll(HttpServletRequest request)
	{
		int sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		Supplier s=new Supplier();
		s.setSid(sid);
		s.setSname(sname);
		
		supplierDao.updateSupplier(s);
		
		return new ModelAndView("index");

		
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request)
	{
		int sid=Integer.parseInt(request.getParameter("sid"));
		//Supplier supplier=supplierDao.getSupplierById(sid);
		supplierDao.deleteSupplier(sid);
		return new ModelAndView("index");
	}
}
