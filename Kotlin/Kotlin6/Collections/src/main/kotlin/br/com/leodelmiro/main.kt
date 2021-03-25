package br.com.leodelmiro

fun main() {
    val pedidos = listOf(
        Pedido(1, 20.0),
        Pedido(2, 60.0),
        Pedido(3, 30.0),
        Pedido(4, 70.0),
    )
    println(pedidos)

    val pedidosMapeados = pedidos.associateBy { pedido ->
        pedido.numero
//        pedido.numero to pedido
    }
    println(pedidosMapeados)
    println(pedidosMapeados[1])

    val pedidosFreteGratis = pedidos.associateWith { pedido ->
        pedido.valor > 50
    }
    println(pedidosFreteGratis)
    println(pedidosFreteGratis[Pedido(numero = 2, valor = 60.0)])

//    val mapa: Map<Boolean, Pedido> = pedidos.associateBy { pedido ->
//        pedido.valor > 50.0
//    }
//    println(mapa)

    val pedidosFreteGratisAgrupados = pedidos.groupBy { pedido: Pedido ->
        pedido.valor > 50.0
    }
    println(pedidosFreteGratisAgrupados)
    println(pedidosFreteGratisAgrupados[false])

    val nomes = listOf(
        "Alex",
        "Fran",
        "Gui",
        "Ana",
        "Paulo",
        "Maria",
        "Mario",
        "Gisele"
    )

    val agenda = nomes.groupBy { nome -> nome.first() }

    println(agenda)
}

data class Pedido(val numero: Int, val valor: Double)

