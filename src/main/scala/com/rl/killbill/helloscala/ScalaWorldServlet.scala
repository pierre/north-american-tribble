package com.rl.killbill.helloscala

import javax.servlet.http.{HttpServletRequest, HttpServlet, HttpServletResponse}

import org.osgi.service.log.LogService

class ScalaWorldServlet(logService:LogService) extends HttpServlet {

  override def doGet(request: HttpServletRequest,  response:HttpServletResponse): Unit ={
    logService.log(LogService.LOG_INFO, "Hello World")
    val writer = response.getWriter
    writer.write("<h1>Hello World!</h1>")
    writer.close()
  }

}
