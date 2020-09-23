package pro.wsmi.kwsmilib.js.dom

import org.w3c.dom.Document
import org.w3c.dom.get

fun Document.removeAllElementsWithClassName(className: String) {
    this.getElementsByClassName(className).let {
        while (it.length > 0)
            it[0]?.remove()
    }
}

fun Document.removeAllElementsWithClassNames(classNames: List<String>) {
    classNames.forEach {
        this.removeAllElementsWithClassName(it)
    }
}