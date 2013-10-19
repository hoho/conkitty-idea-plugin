/* The following code was generated by JFlex 1.4.3 on 10/19/13 4:03 PM */

package com.hoho.conkitty;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.hoho.conkitty.psi.ConkittyTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 10/19/13 4:03 PM from the specification file
 * <tt>/Users/hoho/Work/conkittyPlugin/src/com/hoho/conkitty/Conkitty.flex</tt>
 */
public class _ConkittyLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\2\1\0\1\1\1\1\22\0\1\1\1\0\1\7"+
    "\4\0\1\5\2\0\1\4\4\0\1\3\12\11\7\0\1\13\1\12"+
    "\1\16\1\31\1\23\1\36\1\12\1\20\1\24\2\12\1\17\1\12"+
    "\1\25\1\21\1\27\1\12\1\15\1\22\1\14\2\12\1\26\1\12"+
    "\1\30\1\12\1\0\1\6\2\0\1\11\1\0\1\33\1\12\1\37"+
    "\1\12\1\35\3\12\1\44\1\41\2\12\1\34\1\32\1\12\1\45"+
    "\1\12\1\43\1\40\1\46\1\12\1\42\4\12\57\0\1\10\12\0"+
    "\1\10\4\0\1\10\5\0\27\10\1\0\37\10\1\0\u013f\10\31\0"+
    "\162\10\4\0\14\10\16\0\5\10\11\0\1\10\213\0\1\10\13\0"+
    "\1\10\1\0\3\10\1\0\1\10\1\0\24\10\1\0\54\10\1\0"+
    "\46\10\1\0\5\10\4\0\202\10\10\0\105\10\1\0\46\10\2\0"+
    "\2\10\6\0\20\10\41\0\46\10\2\0\1\10\7\0\47\10\110\0"+
    "\33\10\5\0\3\10\56\0\32\10\5\0\13\10\43\0\2\10\1\0"+
    "\143\10\1\0\1\10\17\0\2\10\7\0\2\10\12\0\3\10\2\0"+
    "\1\10\20\0\1\10\1\0\36\10\35\0\3\10\60\0\46\10\13\0"+
    "\1\10\u0152\0\66\10\3\0\1\10\22\0\1\10\7\0\12\10\43\0"+
    "\10\10\2\0\2\10\2\0\26\10\1\0\7\10\1\0\1\10\3\0"+
    "\4\10\3\0\1\10\36\0\2\10\1\0\3\10\16\0\2\10\23\0"+
    "\6\10\4\0\2\10\2\0\26\10\1\0\7\10\1\0\2\10\1\0"+
    "\2\10\1\0\2\10\37\0\4\10\1\0\1\10\23\0\3\10\20\0"+
    "\11\10\1\0\3\10\1\0\26\10\1\0\7\10\1\0\2\10\1\0"+
    "\5\10\3\0\1\10\22\0\1\10\17\0\2\10\43\0\10\10\2\0"+
    "\2\10\2\0\26\10\1\0\7\10\1\0\2\10\1\0\5\10\3\0"+
    "\1\10\36\0\2\10\1\0\3\10\17\0\1\10\21\0\1\10\1\0"+
    "\6\10\3\0\3\10\1\0\4\10\3\0\2\10\1\0\1\10\1\0"+
    "\2\10\3\0\2\10\3\0\3\10\3\0\10\10\1\0\3\10\113\0"+
    "\10\10\1\0\3\10\1\0\27\10\1\0\12\10\1\0\5\10\46\0"+
    "\2\10\43\0\10\10\1\0\3\10\1\0\27\10\1\0\12\10\1\0"+
    "\5\10\3\0\1\10\40\0\1\10\1\0\2\10\43\0\10\10\1\0"+
    "\3\10\1\0\27\10\1\0\20\10\46\0\2\10\43\0\22\10\3\0"+
    "\30\10\1\0\11\10\1\0\1\10\2\0\7\10\72\0\60\10\1\0"+
    "\2\10\14\0\7\10\72\0\2\10\1\0\1\10\2\0\2\10\1\0"+
    "\1\10\2\0\1\10\6\0\4\10\1\0\7\10\1\0\3\10\1\0"+
    "\1\10\1\0\1\10\2\0\2\10\1\0\4\10\1\0\2\10\11\0"+
    "\1\10\2\0\5\10\1\0\1\10\25\0\2\10\42\0\1\10\77\0"+
    "\10\10\1\0\42\10\35\0\4\10\164\0\42\10\1\0\5\10\1\0"+
    "\2\10\45\0\6\10\112\0\46\10\12\0\51\10\7\0\132\10\5\0"+
    "\104\10\5\0\122\10\6\0\7\10\1\0\77\10\1\0\1\10\1\0"+
    "\4\10\2\0\7\10\1\0\1\10\1\0\4\10\2\0\47\10\1\0"+
    "\1\10\1\0\4\10\2\0\37\10\1\0\1\10\1\0\4\10\2\0"+
    "\7\10\1\0\1\10\1\0\4\10\2\0\7\10\1\0\7\10\1\0"+
    "\27\10\1\0\37\10\1\0\1\10\1\0\4\10\2\0\7\10\1\0"+
    "\47\10\1\0\23\10\105\0\125\10\14\0\u026c\10\2\0\10\10\12\0"+
    "\32\10\5\0\113\10\25\0\15\10\1\0\4\10\16\0\22\10\16\0"+
    "\22\10\16\0\15\10\1\0\3\10\17\0\64\10\43\0\1\10\4\0"+
    "\1\10\103\0\130\10\10\0\51\10\127\0\35\10\63\0\36\10\2\0"+
    "\5\10\u038b\0\154\10\224\0\234\10\4\0\132\10\6\0\26\10\2\0"+
    "\6\10\2\0\46\10\2\0\6\10\2\0\10\10\1\0\1\10\1\0"+
    "\1\10\1\0\1\10\1\0\37\10\2\0\65\10\1\0\7\10\1\0"+
    "\1\10\3\0\3\10\1\0\7\10\3\0\4\10\2\0\6\10\4\0"+
    "\15\10\5\0\3\10\1\0\7\10\164\0\1\10\15\0\1\10\202\0"+
    "\1\10\4\0\1\10\2\0\12\10\1\0\1\10\3\0\5\10\6\0"+
    "\1\10\1\0\1\10\1\0\1\10\1\0\4\10\1\0\3\10\1\0"+
    "\7\10\3\0\3\10\5\0\5\10\u0ebb\0\2\10\52\0\5\10\5\0"+
    "\2\10\4\0\126\10\6\0\3\10\1\0\132\10\1\0\4\10\5\0"+
    "\50\10\4\0\136\10\21\0\30\10\70\0\20\10\u0200\0\u19b6\10\112\0"+
    "\u51a6\10\132\0\u048d\10\u0773\0\u2ba4\10\u215c\0\u012e\10\2\0\73\10\225\0"+
    "\7\10\14\0\5\10\5\0\1\10\1\0\12\10\1\0\15\10\1\0"+
    "\5\10\1\0\1\10\1\0\2\10\1\0\2\10\1\0\154\10\41\0"+
    "\u016b\10\22\0\100\10\2\0\66\10\50\0\14\10\164\0\5\10\1\0"+
    "\207\10\44\0\32\10\6\0\32\10\13\0\131\10\3\0\6\10\2\0"+
    "\6\10\2\0\6\10\2\0\3\10\43\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\3\1\16\3\1\4\2\0\1\5"+
    "\3\0\21\3\1\0\5\3\1\6\10\3\1\7\1\3"+
    "\1\4\1\10\5\3\1\11\7\3\1\12\1\3\1\13"+
    "\4\3\1\14";

  private static int [] zzUnpackAction() {
    int [] result = new int[84];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\47\0\116\0\165\0\234\0\303\0\352\0\u0111"+
    "\0\u0138\0\u015f\0\u0186\0\u01ad\0\u01d4\0\u01fb\0\u0222\0\u0249"+
    "\0\u0270\0\u0297\0\u02be\0\u02e5\0\u030c\0\u0333\0\234\0\47"+
    "\0\u035a\0\303\0\u0381\0\u03a8\0\u03cf\0\u03f6\0\u041d\0\u0444"+
    "\0\u046b\0\u0492\0\u04b9\0\u04e0\0\u0507\0\u052e\0\u0555\0\u057c"+
    "\0\u05a3\0\u05ca\0\u05f1\0\u0618\0\u063f\0\u0666\0\u068d\0\u06b4"+
    "\0\u06db\0\u0702\0\352\0\u0729\0\u0750\0\u0777\0\u079e\0\u07c5"+
    "\0\u07ec\0\u0813\0\u083a\0\352\0\u0861\0\u0333\0\352\0\u0888"+
    "\0\u08af\0\u08d6\0\u08fd\0\u0924\0\352\0\u094b\0\u0972\0\u0999"+
    "\0\u09c0\0\u09e7\0\u0a0e\0\u0a35\0\352\0\u0a5c\0\352\0\u0a83"+
    "\0\u0aaa\0\u0ad1\0\u0af8\0\352";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[84];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\2\1\5\1\2\1\6\1\7"+
    "\1\2\1\7\1\10\1\11\1\7\1\12\2\7\1\13"+
    "\1\14\1\15\1\16\1\7\1\17\1\20\1\7\1\21"+
    "\1\22\4\7\1\23\1\7\1\24\5\7\50\0\2\3"+
    "\47\0\1\25\1\26\42\0\5\27\1\30\1\31\40\27"+
    "\6\32\1\33\1\30\37\32\11\0\36\7\11\0\3\7"+
    "\1\34\32\7\11\0\12\7\1\35\23\7\11\0\2\7"+
    "\1\36\1\7\1\37\2\7\1\40\26\7\11\0\3\7"+
    "\1\41\32\7\11\0\12\7\1\42\23\7\11\0\2\7"+
    "\1\43\3\7\1\44\27\7\11\0\14\7\1\45\21\7"+
    "\11\0\7\7\1\46\3\7\1\47\22\7\11\0\2\7"+
    "\1\50\33\7\11\0\12\7\1\51\23\7\11\0\22\7"+
    "\1\52\13\7\11\0\27\7\1\53\6\7\11\0\22\7"+
    "\1\54\13\7\2\25\1\0\44\25\4\26\1\55\42\26"+
    "\2\27\1\0\44\27\2\32\1\0\44\32\11\0\3\7"+
    "\1\56\32\7\11\0\11\7\1\42\24\7\11\0\6\7"+
    "\1\57\27\7\11\0\6\7\1\60\27\7\11\0\10\7"+
    "\1\61\25\7\11\0\7\7\1\62\26\7\11\0\3\7"+
    "\1\63\32\7\11\0\5\7\1\64\30\7\11\0\11\7"+
    "\1\65\24\7\11\0\11\7\1\66\6\7\1\67\15\7"+
    "\11\0\12\7\1\70\23\7\11\0\3\7\1\64\32\7"+
    "\11\0\17\7\1\71\16\7\11\0\20\7\1\72\15\7"+
    "\11\0\23\7\1\73\12\7\11\0\27\7\1\74\6\7"+
    "\11\0\31\7\1\75\4\7\3\26\1\76\1\55\42\26"+
    "\11\0\4\7\1\63\31\7\11\0\6\7\1\63\27\7"+
    "\11\0\25\7\1\77\10\7\11\0\10\7\1\44\25\7"+
    "\11\0\12\7\1\100\23\7\11\0\7\7\1\63\26\7"+
    "\11\0\12\7\1\63\23\7\11\0\12\7\1\101\23\7"+
    "\11\0\12\7\1\102\23\7\11\0\14\7\1\63\21\7"+
    "\11\0\6\7\1\103\27\7\11\0\12\7\1\104\23\7"+
    "\11\0\24\7\1\105\11\7\11\0\22\7\1\106\13\7"+
    "\11\0\4\7\1\107\31\7\11\0\4\7\1\42\31\7"+
    "\11\0\14\7\1\110\21\7\11\0\10\7\1\111\25\7"+
    "\11\0\14\7\1\112\21\7\11\0\27\7\1\113\6\7"+
    "\11\0\15\7\1\114\20\7\11\0\3\7\1\115\32\7"+
    "\11\0\2\7\1\116\33\7\11\0\3\7\1\117\32\7"+
    "\11\0\26\7\1\120\7\7\11\0\13\7\1\44\22\7"+
    "\11\0\20\7\1\63\15\7\11\0\32\7\1\121\3\7"+
    "\11\0\33\7\1\122\2\7\11\0\34\7\1\123\1\7"+
    "\11\0\35\7\1\124";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2847];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\23\1\2\0\1\11\3\0\21\1\1\0"+
    "\47\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[84];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  _ConkittyLexer() {
    this((java.io.Reader)null);
  }

  public final void setStart(int start) {
    zzCurrentPos = zzStartRead = start;
  }

/*  private IElementType ncName() {
    yybegin(S1);
    return XPathTokenTypes.NCNAME;
  }

  protected abstract void readComment() throws java.io.IOException;*/


  public _ConkittyLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public _ConkittyLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1232) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL.charAt(zzCurrentPosL++);
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL.charAt(zzCurrentPosL++);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 8: 
          { return CRLF;
          }
        case 13: break;
        case 9: 
          { return NAME;
          }
        case 14: break;
        case 6: 
          { return KEYWORD;
          }
        case 15: break;
        case 10: 
          { return INDENT;
          }
        case 16: break;
        case 12: 
          { return JAVASCRIPT;
          }
        case 17: break;
        case 4: 
          { return COMMENT;
          }
        case 18: break;
        case 2: 
          { return com.intellij.psi.TokenType.WHITE_SPACE;
          }
        case 19: break;
        case 3: 
          { return IDENTIFIER;
          }
        case 20: break;
        case 1: 
          { return com.intellij.psi.TokenType.BAD_CHARACTER;
          }
        case 21: break;
        case 7: 
          { return CSS;
          }
        case 22: break;
        case 5: 
          { return STRING;
          }
        case 23: break;
        case 11: 
          { return DEDENT;
          }
        case 24: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
