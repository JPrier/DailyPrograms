import winsound


def solfege():
    # list of notes
    freq = [262, 294, 330, 349, 392, 440, 494]
    duration = 250

    # play each note from freq in succession
    for note in freq:
        winsound.Beep(note, duration)

if __name__ == "__main__":
    solfege()