package com.rl.killbill.helloscala

import java.util.UUID

import org.killbill.billing.account.api.AccountApiException
import org.killbill.billing.util.callcontext.TenantContext
import org.killbill.killbill.osgi.libs.killbill.OSGIKillbillAPI
import org.killbill.killbill.osgi.libs.killbill.OSGIKillbillEventDispatcher.OSGIKillbillEventHandler
import org.killbill.killbill.osgi.libs.killbill.OSGIKillbillLogService
import org.killbill.billing.notification.plugin.api.ExtBusEvent
import org.osgi.service.log.LogService

class ScalaHelloWorldListener(logService:OSGIKillbillLogService, killbillAPI: OSGIKillbillAPI) extends OSGIKillbillEventHandler{

  def handleKillbillEvent(kbEvent: ExtBusEvent) = {
    println("Hello from Scala")
    logService.log(LogService.LOG_INFO, "Received event " + kbEvent.getEventType +
      " for object id " + kbEvent.getObjectId +
      " of type " + kbEvent.getObjectType)
    try {
      val account = killbillAPI.getAccountUserApi.getAccountById(kbEvent.getAccountId, new ScalaHelloWorldTenantContext(kbEvent.getTenantId))
      logService.log(LogService.LOG_INFO, "Account information: " + account)
    }
    catch{
      case e:AccountApiException => logService.log(LogService.LOG_WARNING, "Unable to find account", e)
    }
  }
}

class ScalaHelloWorldTenantContext(tenantId:UUID) extends TenantContext{

  def getTenantId:UUID = {
    tenantId
  }

}
