package net.kirkstork.reproducer

import tornadofx.*

class Bug775App : App(Bug775Workspace::class, Styles::class) {

	override fun onBeforeShow(view: UIComponent) {
		workspace.dock<StartView>()
	}
}