import com.github.fbaierl.tarjan.{TarjanRecursive => lib}

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("Tarjan")
object Tarjan {

  @JSExport
  def tarjan[T](g: Map[T, List[T]]): Unit = lib.tarjan(g)

}

