def pattern(word, pat):
    """
    Return true if the word contains the pattern, pat.

    :param word: str
    :param pat: str
    :return: bool
    """
    matches = {}
    if len(word) < len(pat):
        return False
    for (w,p) in zip(word, pat):
        if p not in matches:
            matches[p] = w
        elif matches[p] != w:
            return pattern(word[1:], pat)
    return True

if __name__ == "__main__":
    import sys
    # check if there is enough arguments
    if len(sys.argv) < 3:
        exit()
    # input a dictionary
    dictFile = open(sys.argv[2], "r")
    # get the pattern to follow
    pat = sys.argv[3]
    # iterate over each word, printing only those that follow the pattern
    for word in dictFile:
        if pattern(word, pat):
            print(word)
