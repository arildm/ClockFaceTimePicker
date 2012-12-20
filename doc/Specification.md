# About

The idea of this timepicker component is to provide a quicker use than Android's default picker. It attempts to accomplish this by presenting circular sliders resembling the face of a clock.

# Specification

Also, please see graphical design sketch.

## Appearance

The main area of the component consists of two circular slider (or seekbar) controls, one within the other. The inner is for hours and the outer is for minutes. The inner is split in two rounds in order to cover both am and pm (or does otherwise distinguish graphically between the two).

Above the circular sliders sits a traditional pair of numerical pickers, synchronized with the sliders.

## Interaction

When a point on a slider is tapped, the slider control moves to the closest 12th of a round. This means resolutions of 5 minutes and 1 hour respectively.

If the minute slider is tapped quickly again, the control can be dragged by 1 minute precision. (Perhaps "swiped" is more correct than "dragged" - no wait is necessary.)

When the hour slider is tapped at a point equivalent to the current position, the selected value changes between am and pm.

Each picker is equipped with arrowhead (triangular) buttons above and below for stepwise adjustment.

The default value is midnight, that is 00:00 or 12:00 am.

# Typical use

Say that the time of day, to which the user intends to set some setting, is 15:42 or 3:42 pm. They could then tap one quarter into the hour slider for 3, and a third into the minute slider for 40.

Checking the result on the numerical picker, they might first notice that the minute value is off by -2, and tap twice on the picker's increment button to correct it. Or, they might tap again at the slider, at which the control will snap to a 1-minute precision, and drag it until the picker shows 42.

They would then, presumably, notice that the hour value is on the wrong side off midday. Trying again to tap the slider control in place will switch to 15 (or pm) and the user should be content.

This procedure should not take more than 2 seconds and 4-5 strokes.
