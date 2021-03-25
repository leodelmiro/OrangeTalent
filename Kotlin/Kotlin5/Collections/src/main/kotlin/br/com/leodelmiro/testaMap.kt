package br.com.leodelmiro

fun testaComportamentosMap() {
    val pedidos = mutableMapOf<Int, Double>(
        Pair(1, 20.0),
        Pair(2, 34.0),
        3 to 50.0,
        4 to 100.0,
        5 to 150.0,
        6 to 80.0
    )
//    val valorPedido = pedidos.getValue(5)
//    println(valorPedido)
    val mensagem = pedidos.getOrElse(0, {
        0.0
    })
    println(mensagem)

    println(pedidos.getOrDefault(0, -1))

    println(pedidos.keys)

    for (numero in pedidos.keys) {
        println("Pedido $numero")
    }

    println(pedidos.values)
    for (valor in pedidos.values) {
        println("Pedido $valor")
    }

    val pedidosFiltrados = pedidos.filter { (numero, valor) ->
        numero % 2 == 0 && valor > 50.0
    }

    println(pedidosFiltrados)

    val pedidosAcima = pedidos.filterValues { valor ->
        valor > 70.0
    }

    println(pedidosAcima)

    val pedidosPares = pedidos.filterKeys { numero ->
        numero % 2 == 0
    }

    println(pedidosPares)

    println(pedidos + mapOf(7 to 90.0, 8 to 20.0))
    println(pedidos)

    println(pedidos - listOf(6, 5))
    println(pedidos)

//    pedidos.putAll(listOf(7 to 90.0, 8 to 20.0, 8 to 30.0))
//    pedidos.putAll(setOf(7 to 90.0, 8 to 20.0, 8 to 30.0))
    pedidos += listOf(7 to 90.0, 8 to 20.0, 8 to 30.0)
    println(pedidos)

    pedidos.keys.remove(1)
    println(pedidos)

    pedidos.values.remove(30.0)
    println(pedidos)

    pedidos.values.remove(100.0)
    println(pedidos)

    pedidos -= 6
    println(pedidos)
}

fun testaMap(pedidos: MutableMap<Int, Double>) {
    println(pedidos)
    val pedido = pedidos[0]
    pedido?.let {
        println("pedido $it")
    }

    for (p in pedidos) {
        println("número do pedido: ${p.key}")
        println("valor do pedido: ${p.value}")
    }

    pedidos[4] = 70.0
    println(pedidos)
    pedidos.put(5, 80.0)
    println(pedidos)
    pedidos[1] = 100.0
    println(pedidos)
    pedidos.putIfAbsent(6, 200.0)
    println(pedidos)
    pedidos.putIfAbsent(6, 300.0)
    println(pedidos)

    pedidos.remove(6)
    println(pedidos)
    pedidos.remove(3, 50.0)
    println(pedidos)
}

