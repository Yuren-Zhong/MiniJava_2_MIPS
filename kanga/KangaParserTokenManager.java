package kanga;
/* Generated By:JavaCC: Do not edit this line. KangaParserTokenManager.java */

public class KangaParserTokenManager implements KangaParserConstants
{
  public static  java.io.PrintStream debugStream = System.out;
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0, long active1)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0xffffffffffff0000L) != 0L || (active1 & 0x3ffffL) != 0L)
         {
            jjmatchedKind = 83;
            return 4;
         }
         return -1;
      case 1:
         if ((active0 & 0xfff80000023f0000L) != 0L || (active1 & 0x3ffffL) != 0L)
            return 4;
         if ((active0 & 0x7fffffdc00000L) != 0L)
         {
            jjmatchedKind = 83;
            jjmatchedPos = 1;
            return 4;
         }
         return -1;
      case 2:
         if ((active0 & 0x2800105000000L) != 0L)
            return 4;
         if ((active0 & 0x57ffef8c00000L) != 0L)
         {
            jjmatchedKind = 83;
            jjmatchedPos = 2;
            return 4;
         }
         return -1;
      case 3:
         if ((active0 & 0x5010e30400000L) != 0L)
            return 4;
         if ((active0 & 0x7ef0c8800000L) != 0L)
         {
            jjmatchedKind = 83;
            jjmatchedPos = 3;
            return 4;
         }
         return -1;
      case 4:
         if ((active0 & 0x1a7008800000L) != 0L)
            return 4;
         if ((active0 & 0x6480c0000000L) != 0L)
         {
            jjmatchedKind = 83;
            jjmatchedPos = 4;
            return 4;
         }
         return -1;
      case 5:
         if ((active0 & 0x248000000000L) != 0L)
            return 4;
         if ((active0 & 0x4000c0000000L) != 0L)
         {
            jjmatchedKind = 83;
            jjmatchedPos = 5;
            return 4;
         }
         return -1;
      case 6:
         if ((active0 & 0x400000000000L) != 0L)
            return 4;
         if ((active0 & 0xc0000000L) != 0L)
         {
            jjmatchedKind = 83;
            jjmatchedPos = 6;
            return 4;
         }
         return -1;
      case 7:
         if ((active0 & 0xc0000000L) != 0L)
         {
            jjmatchedKind = 83;
            jjmatchedPos = 7;
            return 4;
         }
         return -1;
      case 8:
         if ((active0 & 0x40000000L) != 0L)
            return 4;
         if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 83;
            jjmatchedPos = 8;
            return 4;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0, long active1)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
static private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 40:
         return jjStopAtPos(0, 9);
      case 41:
         return jjStopAtPos(0, 10);
      case 46:
         return jjStopAtPos(0, 15);
      case 65:
         return jjMoveStringLiteralDfa1_0(0x2300001000000L, 0x0L);
      case 66:
         return jjMoveStringLiteralDfa1_0(0x4000000000L, 0x0L);
      case 67:
         return jjMoveStringLiteralDfa1_0(0x20820000000L, 0x0L);
      case 69:
         return jjMoveStringLiteralDfa1_0(0x1100200000L, 0x0L);
      case 71:
         return jjMoveStringLiteralDfa1_0(0xc0000L, 0x0L);
      case 72:
         return jjMoveStringLiteralDfa1_0(0xc0040000000L, 0x0L);
      case 74:
         return jjMoveStringLiteralDfa1_0(0x10000000000L, 0x0L);
      case 76:
         return jjMoveStringLiteralDfa1_0(0x30000L, 0x0L);
      case 77:
         return jjMoveStringLiteralDfa1_0(0x800410800000L, 0x0L);
      case 78:
         return jjMoveStringLiteralDfa1_0(0x204100000L, 0x0L);
      case 79:
         return jjMoveStringLiteralDfa1_0(0x2000000L, 0x0L);
      case 80:
         return jjMoveStringLiteralDfa1_0(0x402000400000L, 0x0L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x8000000000L, 0x0L);
      case 83:
         return jjMoveStringLiteralDfa1_0(0x80000000L, 0x0L);
      case 84:
         return jjMoveStringLiteralDfa1_0(0x1000008000000L, 0x0L);
      case 91:
         return jjStopAtPos(0, 13);
      case 93:
         return jjStopAtPos(0, 14);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x3c8000000000000L, 0x0L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x10000L);
      case 103:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x4000L);
      case 107:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x3000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x20000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x83fcL);
      case 116:
         return jjMoveStringLiteralDfa1_0(0xfc00000000000000L, 0xc03L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x30000000000000L, 0x0L);
      case 122:
         return jjMoveStringLiteralDfa1_0(0x4000000000000L, 0x0L);
      case 123:
         return jjStopAtPos(0, 11);
      case 125:
         return jjStopAtPos(0, 12);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
static private final int jjMoveStringLiteralDfa1_0(long active0, long active1)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1);
      return 1;
   }
   switch(curChar)
   {
      case 48:
         if ((active0 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 52, 4);
         else if ((active0 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 54, 4);
         else if ((active0 & 0x400000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 58, 4);
         else if ((active1 & 0x4L) != 0L)
            return jjStartNfaWithStates_0(1, 66, 4);
         else if ((active1 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(1, 76, 4);
         break;
      case 49:
         if ((active0 & 0x20000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 53, 4);
         else if ((active0 & 0x80000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 55, 4);
         else if ((active0 & 0x800000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 59, 4);
         else if ((active1 & 0x8L) != 0L)
            return jjStartNfaWithStates_0(1, 67, 4);
         else if ((active1 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(1, 77, 4);
         break;
      case 50:
         if ((active0 & 0x100000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 56, 4);
         else if ((active0 & 0x1000000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 60, 4);
         else if ((active1 & 0x10L) != 0L)
            return jjStartNfaWithStates_0(1, 68, 4);
         break;
      case 51:
         if ((active0 & 0x200000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 57, 4);
         else if ((active0 & 0x2000000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 61, 4);
         else if ((active1 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(1, 69, 4);
         break;
      case 52:
         if ((active0 & 0x4000000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 62, 4);
         else if ((active1 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(1, 70, 4);
         break;
      case 53:
         if ((active0 & 0x8000000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 63, 4);
         else if ((active1 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(1, 71, 4);
         break;
      case 54:
         if ((active1 & 0x1L) != 0L)
            return jjStartNfaWithStates_0(1, 64, 4);
         else if ((active1 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(1, 72, 4);
         break;
      case 55:
         if ((active1 & 0x2L) != 0L)
            return jjStartNfaWithStates_0(1, 65, 4);
         else if ((active1 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(1, 73, 4);
         break;
      case 56:
         if ((active1 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(1, 74, 4);
         break;
      case 57:
         if ((active1 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(1, 75, 4);
         break;
      case 65:
         return jjMoveStringLiteralDfa2_0(active0, 0x400850000000L, active1, 0L);
      case 69:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(1, 17, 4);
         else if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(1, 19, 4);
         else if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(1, 20, 4);
         return jjMoveStringLiteralDfa2_0(active0, 0x180c000000000L, active1, 0L);
      case 73:
         return jjMoveStringLiteralDfa2_0(active0, 0x8800000L, active1, 0L);
      case 74:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000000000L, active1, 0L);
      case 76:
         return jjMoveStringLiteralDfa2_0(active0, 0x180000400000L, active1, 0L);
      case 78:
         return jjMoveStringLiteralDfa2_0(active0, 0x101000000L, active1, 0L);
      case 79:
         return jjMoveStringLiteralDfa2_0(active0, 0x624000000L, active1, 0L);
      case 80:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000L, active1, 0L);
      case 81:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(1, 21, 4);
         break;
      case 82:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(1, 25, 4);
         return jjMoveStringLiteralDfa2_0(active0, 0x2003000000000L, active1, 0L);
      case 83:
         return jjMoveStringLiteralDfa2_0(active0, 0x240000000000L, active1, 0L);
      case 84:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(1, 16, 4);
         else if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(1, 18, 4);
         break;
      case 85:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000000000L, active1, 0L);
      case 97:
         if ((active1 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(1, 81, 4);
         break;
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000000000L, active1, 0L);
      case 112:
         if ((active1 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(1, 78, 4);
         else if ((active1 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(1, 79, 4);
         else if ((active1 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(1, 80, 4);
         break;
      case 116:
         if ((active0 & 0x8000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 51, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1);
}
static private final int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(0, old0, old1); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, 0L);
      return 2;
   }
   switch(curChar)
   {
      case 68:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(2, 24, 4);
         else if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(2, 32, 4);
         return jjMoveStringLiteralDfa3_0(active0, 0x20000000L);
      case 71:
         if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 49, 4);
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000000L);
      case 73:
         return jjMoveStringLiteralDfa3_0(active0, 0x2090000000L);
      case 76:
         return jjMoveStringLiteralDfa3_0(active0, 0x840000000L);
      case 77:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 47, 4);
         return jjMoveStringLiteralDfa3_0(active0, 0x1010008000000L);
      case 78:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000L);
      case 79:
         return jjMoveStringLiteralDfa3_0(active0, 0x180200000000L);
      case 82:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000000L);
      case 83:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000000000L);
      case 84:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(2, 26, 4);
         return jjMoveStringLiteralDfa3_0(active0, 0x248000000000L);
      case 85:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000400000L);
      case 86:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0, 0L);
}
static private final int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, 0L);
      return 3;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa4_0(active0, 0x180000000000L);
      case 69:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(3, 29, 4);
         else if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(3, 34, 4);
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000L);
      case 73:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000000L);
      case 76:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(3, 35, 4);
         return jjMoveStringLiteralDfa4_0(active0, 0xc0000000L);
      case 77:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000000000L);
      case 78:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(3, 28, 4);
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000000L);
      case 79:
         return jjMoveStringLiteralDfa4_0(active0, 0x241000000000L);
      case 80:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(3, 33, 4);
         else if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 40, 4);
         else if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 48, 4);
         break;
      case 83:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(3, 22, 4);
         return jjMoveStringLiteralDfa4_0(active0, 0x400000000000L);
      case 85:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000800000L);
      case 111:
         if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 50, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(2, active0, 0L);
}
static private final int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa5_0(active0, 0x400000000000L);
      case 68:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 43, 4);
         else if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 44, 4);
         break;
      case 76:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000L);
      case 78:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 38, 4);
         break;
      case 79:
         return jjMoveStringLiteralDfa5_0(active0, 0x40000000L);
      case 80:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 41, 4);
         break;
      case 82:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 36, 4);
         return jjMoveStringLiteralDfa5_0(active0, 0x248000000000L);
      case 83:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(4, 23, 4);
         else if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(4, 27, 4);
         break;
      case 84:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 37, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0, 0L);
}
static private final int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 67:
         return jjMoveStringLiteralDfa6_0(active0, 0x40000000L);
      case 69:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 42, 4);
         else if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 45, 4);
         return jjMoveStringLiteralDfa6_0(active0, 0x80000000L);
      case 78:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 39, 4);
         break;
      case 82:
         return jjMoveStringLiteralDfa6_0(active0, 0x400000000000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0, 0L);
}
static private final int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa7_0(active0, 0x40000000L);
      case 68:
         return jjMoveStringLiteralDfa7_0(active0, 0x80000000L);
      case 71:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 46, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0, 0L);
}
static private final int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 65:
         return jjMoveStringLiteralDfa8_0(active0, 0x80000000L);
      case 84:
         return jjMoveStringLiteralDfa8_0(active0, 0x40000000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0, 0L);
}
static private final int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0, 0L);
      return 8;
   }
   switch(curChar)
   {
      case 69:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(8, 30, 4);
         break;
      case 82:
         return jjMoveStringLiteralDfa9_0(active0, 0x80000000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0, 0L);
}
static private final int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0, 0L);
      return 9;
   }
   switch(curChar)
   {
      case 71:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(9, 31, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(8, active0, 0L);
}
static private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
static private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
static private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
static final long[] jjbitVec0 = {
   0x1ff00000fffffffeL, 0xffffffffffffc000L, 0xffffffffL, 0x600000000000000L
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0x0L, 0xff7fffffff7fffffL
};
static final long[] jjbitVec3 = {
   0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec4 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffL, 0x0L
};
static final long[] jjbitVec5 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0x0L, 0x0L
};
static final long[] jjbitVec6 = {
   0x3fffffffffffL, 0x0L, 0x0L, 0x0L
};
static final long[] jjbitVec7 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec8 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 24;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 82)
                        kind = 82;
                     jjCheckNAdd(1);
                  }
                  else if (curChar == 47)
                     jjAddStates(0, 2);
                  else if (curChar == 36)
                  {
                     if (kind > 83)
                        kind = 83;
                     jjCheckNAdd(4);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 82)
                        kind = 82;
                  }
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 82)
                     kind = 82;
                  jjCheckNAdd(1);
                  break;
               case 2:
                  if (curChar == 48 && kind > 82)
                     kind = 82;
                  break;
               case 3:
                  if (curChar != 36)
                     break;
                  if (kind > 83)
                     kind = 83;
                  jjCheckNAdd(4);
                  break;
               case 4:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 83)
                     kind = 83;
                  jjCheckNAdd(4);
                  break;
               case 5:
                  if (curChar == 47)
                     jjAddStates(0, 2);
                  break;
               case 6:
                  if (curChar == 47)
                     jjCheckNAddStates(3, 5);
                  break;
               case 7:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(3, 5);
                  break;
               case 8:
                  if ((0x2400L & l) != 0L && kind > 6)
                     kind = 6;
                  break;
               case 9:
                  if (curChar == 10 && kind > 6)
                     kind = 6;
                  break;
               case 10:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 11:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(12, 13);
                  break;
               case 12:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(12, 13);
                  break;
               case 13:
                  if (curChar == 42)
                     jjCheckNAddStates(6, 8);
                  break;
               case 14:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(15, 13);
                  break;
               case 15:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(15, 13);
                  break;
               case 16:
                  if (curChar == 47 && kind > 7)
                     kind = 7;
                  break;
               case 17:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 18:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(19, 20);
                  break;
               case 19:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(19, 20);
                  break;
               case 20:
                  if (curChar == 42)
                     jjCheckNAddStates(9, 11);
                  break;
               case 21:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(22, 20);
                  break;
               case 22:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(22, 20);
                  break;
               case 23:
                  if (curChar == 47 && kind > 8)
                     kind = 8;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 4:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 83)
                     kind = 83;
                  jjCheckNAdd(4);
                  break;
               case 7:
                  jjAddStates(3, 5);
                  break;
               case 12:
                  jjCheckNAddTwoStates(12, 13);
                  break;
               case 14:
               case 15:
                  jjCheckNAddTwoStates(15, 13);
                  break;
               case 19:
                  jjCheckNAddTwoStates(19, 20);
                  break;
               case 21:
               case 22:
                  jjCheckNAddTwoStates(22, 20);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 4:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 83)
                     kind = 83;
                  jjCheckNAdd(4);
                  break;
               case 7:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjAddStates(3, 5);
                  break;
               case 12:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(12, 13);
                  break;
               case 14:
               case 15:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(15, 13);
                  break;
               case 19:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(19, 20);
                  break;
               case 21:
               case 22:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(22, 20);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 24 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   6, 17, 18, 7, 8, 10, 13, 14, 16, 20, 21, 23, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec3[i2] & l2) != 0L);
      case 49:
         return ((jjbitVec4[i2] & l2) != 0L);
      case 51:
         return ((jjbitVec5[i2] & l2) != 0L);
      case 61:
         return ((jjbitVec6[i2] & l2) != 0L);
      default : 
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec8[i2] & l2) != 0L);
      default : 
         if ((jjbitVec7[i1] & l1) != 0L)
            return true;
         return false;
   }
}
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, "\50", "\51", "\173", 
"\175", "\133", "\135", "\56", "\114\124", "\114\105", "\107\124", "\107\105", 
"\116\105", "\105\121", "\120\114\125\123", "\115\111\116\125\123", "\101\116\104", 
"\117\122", "\116\117\124", "\124\111\115\105\123", "\115\101\111\116", 
"\103\117\104\105", "\110\101\114\114\117\103\101\124\105", 
"\123\120\111\114\114\105\104\101\122\107", "\105\116\104", "\116\117\117\120", "\115\117\126\105", "\103\101\114\114", 
"\105\122\122\117\122", "\120\122\111\116\124", "\102\105\107\111\116", "\122\105\124\125\122\116", 
"\112\125\115\120", "\103\112\125\115\120", "\110\123\124\117\122\105", "\110\114\117\101\104", 
"\101\114\117\101\104", "\101\123\124\117\122\105", "\120\101\123\123\101\122\107", "\115\105\115", 
"\124\105\115\120", "\101\122\107", "\172\145\162\157", "\141\164", "\166\60", "\166\61", 
"\141\60", "\141\61", "\141\62", "\141\63", "\164\60", "\164\61", "\164\62", "\164\63", 
"\164\64", "\164\65", "\164\66", "\164\67", "\163\60", "\163\61", "\163\62", "\163\63", 
"\163\64", "\163\65", "\163\66", "\163\67", "\164\70", "\164\71", "\153\60", "\153\61", 
"\147\160", "\163\160", "\146\160", "\162\141", null, null, null, null, };
public static final String[] lexStateNames = {
   "DEFAULT", 
};
static final long[] jjtoToken = {
   0xfffffffffffffe01L, 0xfffffL, 
};
static final long[] jjtoSkip = {
   0x1feL, 0x0L, 
};
static final long[] jjtoSpecial = {
   0x1c0L, 0x0L, 
};
static protected JavaCharStream input_stream;
static private final int[] jjrounds = new int[24];
static private final int[] jjstateSet = new int[48];
static protected char curChar;
public KangaParserTokenManager(JavaCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}
public KangaParserTokenManager(JavaCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}
static public void ReInit(JavaCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 24; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
static public void ReInit(JavaCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

public static Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100003600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         matchedToken.specialToken = specialToken;
         return matchedToken;
      }
      else
      {
         if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
         {
            matchedToken = jjFillToken();
            if (specialToken == null)
               specialToken = matchedToken;
            else
            {
               matchedToken.specialToken = specialToken;
               specialToken = (specialToken.next = matchedToken);
            }
         }
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

}
