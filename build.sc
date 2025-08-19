import mill._, scalalib._

object t extends ScalaModule {
  def scalaVersion = "2.12.18"
  override def millSourcePath = os.pwd // source files should be in millSourcePath / "src"

  def spinalVersion = "1.12.3"
  def ivyDeps = Agg(
    ivy"com.github.spinalhdl::spinalhdl-core:$spinalVersion",
    ivy"com.github.spinalhdl::spinalhdl-lib:$spinalVersion"
  )
  def scalacPluginIvyDeps = Agg(ivy"com.github.spinalhdl::spinalhdl-idsl-plugin:$spinalVersion")
}