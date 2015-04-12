name := "killbill-scala-helloworld"

version := "1.0"

scalaVersion := "2.11.6"

osgiSettings

OsgiKeys.privatePackage := Seq("com.rl.killbill.helloscala")

OsgiKeys.bundleActivator := Option("com.rl.killbill.helloscala.ScalaHelloWorldActivator")
OsgiKeys.importPackage := Seq("*;resolution:=optional")

libraryDependencies ++=  Seq(
  "org.kill-bill.billing" % "killbill-api" % "0.13.0" % "provided",
  "org.kill-bill.billing.plugin" % "killbill-plugin-api-payment" % "0.8.5" % "provided",
  "org.kill-bill.billing.plugin" % "killbill-plugin-api-notification" % "0.8.5" % "provided",
  "org.kill-bill.billing" % "killbill-platform-osgi-api" % "0.1.5",
  "org.kill-bill.billing" % "killbill-platform-osgi-bundles-lib-killbill" % "0.1.5",
  "org.kill-bill.billing" % "killbill-platform-osgi-bundles-lib-slf4j-osgi"% "0.1.5",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "joda-time" % "joda-time" % "2.7",
  "org.osgi" % "org.osgi.core" % "5.0.0",
  "org.osgi" % "org.osgi.compendium" % "5.0.0",
  "org.slf4j" % "slf4j-api" % "1.7.12"
)

