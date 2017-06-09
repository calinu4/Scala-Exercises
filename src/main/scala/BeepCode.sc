import javax.sound.midi.Instrument
import javax.sound.midi.MidiChannel
import javax.sound.midi.Synthesizer
import com.sun.swing.internal.plaf.synth.resources.synth
import javax.sound.midi.MidiSystem

val synth = MidiSystem.getSynthesizer
synth.open()
val list1 =synth.getChannels
val mc=list1(0)
val instrument = synth.getDefaultSoundbank.getInstruments
synth.loadInstrument(instrument(0))
val longDuration = 500
val shortDuration = 250
val pauseDuration = 1500


def BeepCode(code:Char)=code match {
  case '-'=>"LONG"
  case '.'=>"SHORT"
  case ' '=>"PAUSE"
  case _=>"PAUSE"
}

def play(code: String) = {
  code match {
    case "LONG" =>
      mc.noteOn(60, 500)
      Thread.sleep(longDuration)
      mc.noteOff(60)

    case "SHORT" =>
      mc.noteOn(60, 500)
      Thread.sleep(shortDuration)
      mc.noteOff(60)

    case "PAUSE" =>
      Thread.sleep(pauseDuration)

  }
}

def humanToMorseCode(message:String)= {
  message.toCharArray.map(item=>BeepCode(item))
}

val morseMessage:String=".... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.--"
val codes:Array[String]=humanToMorseCode(morseMessage)

codes.foreach(item=>play(item))