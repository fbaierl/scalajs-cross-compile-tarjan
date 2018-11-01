import com.github.fbaierl.tarjan.{TarjanRecursive => lib}

object Tarjan {

  def tarjan[T](g: Map[T, List[T]]): Unit = lib.tarjan(g)

}
