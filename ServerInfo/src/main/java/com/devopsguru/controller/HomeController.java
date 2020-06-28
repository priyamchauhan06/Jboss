package com.devopsguru.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping("/clientinfo")
	public String ClientInfo(HttpServletRequest request, Model model) {
		String ClientIP = "";

        if (request != null) {
        	ClientIP = request.getHeader("X-FORWARDED-FOR");
            if (ClientIP == null || "".equals(ClientIP)) {
            	ClientIP = request.getRemoteAddr();
            }
        }

        model.addAttribute("ClientIP", ClientIP);
		return "clientinfo";
	}

	
	@RequestMapping("/serverinfo")
	public String ServerInfo(HttpServletRequest request, Model model) throws IOException {
		
		InetAddress ip = null;
		  try {
			ip = InetAddress.getLocalHost();
		  } catch (UnknownHostException e) {
			e.printStackTrace();
		  }
		  
		  model.addAttribute("HostIP", ip.getHostAddress());
		  model.addAttribute("HostName", ip.getHostName());
		  model.addAttribute("HostStatus", ip.isReachable(200));
		  
		return "serverinfo";
	}

	@RequestMapping("/jvminfo")	
	public String JvmInfo(HttpServletRequest request, Model model) {
		
		int mb = 1024*1024;
		Runtime runtime = Runtime.getRuntime();
		
		System.out.println("##### Heap utilization statistics [MB] #####");



		//Print total available memory
		long max_memory = (runtime.totalMemory() / mb);
		long total_mem = runtime.totalMemory() / mb;
		long used_mem = (runtime.totalMemory() - runtime.freeMemory()) / mb;
		long free_mem = runtime.freeMemory() / mb;
		
		String Java_ver  = System.getProperty("java.version");
		String Java_ven  = System.getProperty("java.specification.vendor");
		String Java_Jre  = System.getProperty("java.runtime.name");

		model.addAttribute("Total Memory", total_mem);
		model.addAttribute("Used Memory", used_mem);
		model.addAttribute("Free Memory", free_mem);
		model.addAttribute("Max Memory", max_memory);
		model.addAttribute("Java Version", Java_ver);
		model.addAttribute("Java Vendor", Java_ven);
		model.addAttribute("JRE", Java_Jre);
		
		
		return "jvminfo";
	}

}
