package knockoff2

case class SpanMatch(
    val index   : Int,
    val before  : Option[ Text ],
    val current : Span,
    val after   : Option[ String ]
)
