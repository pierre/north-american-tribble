package com.rl.killbill.helloscala

import org.killbill.killbill.osgi.libs.killbill.KillbillActivatorBase;
import org.killbill.killbill.osgi.libs.killbill.OSGIKillbillEventDispatcher.OSGIKillbillEventHandler;
import org.osgi.framework.BundleContext;

class ScalaHelloWorldActivator extends KillbillActivatorBase {
  val PLUGIN_NAME = "hello"

  var analyticsListener : OSGIKillbillEventHandler = null

  override def start(context : BundleContext) = {
    super.start(context)
    analyticsListener = new ScalaHelloWorldListener(logService, killbillAPI)
  }

  def getOSGIKillbillEventHandler: OSGIKillbillEventHandler = {
    analyticsListener
  }
}
