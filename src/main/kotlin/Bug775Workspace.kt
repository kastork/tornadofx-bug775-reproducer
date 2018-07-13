package net.kirkstork.reproducer

import javafx.application.Platform
import tornadofx.*

class Bug775Workspace : Workspace() {

	override fun onDock() {
//    this doesn't seem to work
//		workspace.headingContainer.removeFromParent()
	}

	init {
		// but this does
		showHeadingLabel = false

		add(MainMenuBar::class)
		dock<StartView>()
	}

}

class StartView : View("Bug 775") {

	override val root = borderpane {
		center {
			vbox(20) {
				label("Notice that a warning about invisible workspace is printed on console.")
				label("The button below works before commit 207f446f of tornadofx, but not after.")
				button("Go to UndockableView") {
					action {
						workspace.dock<UndockableView>()
					}
				}
			}
		}
	}

}

class UndockableView : View("Undockable View") {
	override val root = borderpane {
		center {
			label("Undockable")
		}
	}

}


class MainMenuBar : View("My View") {

	override val root = menubar {
		menu("Bug775") {
			item("Quit").action {
				Platform.exit()
			}
		}
	}
}