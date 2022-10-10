import java.time.Duration
import java.time.LocalDateTime

fun main() {
    val lastDateTimeWas: LocalDateTime = LocalDateTime.parse("2022-10-10T22:55:00")
    println(agoToText(lastDateTimeWas))
}

fun agoToText(lastDateTimeWas: LocalDateTime): String {
    val durationTime = Duration.between(lastDateTimeWas, LocalDateTime.now())

    return when {
        durationTime.toDays() > 0 -> "был(а) в сети ${durationDay(durationTime)}"
        durationTime.toHours() > 0 -> "был(а) в сети ${durationHours(durationTime)}"
        durationTime.toMinutes() > 0 -> "был(а) в сети ${durationMinutes(durationTime)}"
        durationTime.toSeconds() > 0 -> "был(а) в сети только что"
        else -> "в будущем всё ещё в сети"
    }
}

fun durationDay(durationTime: Duration): String {
    return when {
        durationTime.toDays() < 2L -> "вчера"
        durationTime.toDays() < 3L -> "позавчера"
        else -> "давно"
    }
}

fun durationHours(durationTime: Duration): String {

    return if (durationTime.toHours() == 1L || durationTime.toHours() == 21L) {
        "${durationTime.toHours()} час назад"
    } else if (durationTime.toHours() in 5..20) {
        "${durationTime.toHours()} часов назад"
    } else {
        "${durationTime.toHours()} часа назад"
    }
}

fun durationMinutes(durationTime: Duration): String {
    return if (durationTime.toMinutes() % 10 == 1L && durationTime.toMinutes() != 11L) {
        "${durationTime.toMinutes()} минуту назад"
    } else if (durationTime.toMinutes() % 10 in 2..4 && durationTime.toMinutes() !in 10..20) {
        "${durationTime.toMinutes()} минуты назад"
    } else {
        "${durationTime.toMinutes()} минут назад"
    }
}