/*------------------------------------------------------------------------------
 * rtklib.h : rtklib constants, types and function prototypes
 *
 *          Copyright (C) 2007-2016 by T.TAKASU, All rights reserved.
 *
 * options : -DENAGLO   enable GLONASS
 *           -DENAGAL   enable Galileo
 *           -DENAQZS   enable QZSS
 *           -DENACMP   enable BeiDou
 *           -DENAIRN   enable IRNSS
 *           -DNFREQ=n  set number of obs codes/frequencies
 *           -DNEXOBS=n set number of extended obs codes
 *           -DMAXOBS=n set max number of obs data in an epoch
 *           -DEXTLEX   enable QZSS LEX extension
 *           -DWIN32    use WIN32 API
 *           -DWIN_DLL  generate library as Windows DLL
 *
 * version : $Revision: 1.1 $ $Date: 2008/07/17 21:48:06 $
 * history : 2007/01/13 1.0  rtklib ver.1.0.0
 *           2007/03/20 1.1  rtklib ver.1.1.0
 *           2008/07/15 1.2  rtklib ver.2.1.0
 *           2008/10/19 1.3  rtklib ver.2.1.1
 *           2009/01/31 1.4  rtklib ver.2.2.0
 *           2009/04/30 1.5  rtklib ver.2.2.1
 *           2009/07/30 1.6  rtklib ver.2.2.2
 *           2009/12/25 1.7  rtklib ver.2.3.0
 *           2010/07/29 1.8  rtklib ver.2.4.0
 *           2011/05/27 1.9  rtklib ver.2.4.1
 *           2013/03/28 1.10 rtklib ver.2.4.2
 *           2016/01/26 1.11 rtklib ver.2.4.3
 *-----------------------------------------------------------------------------*/

import java.lang.String;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class rtklib {
    /* constants -----------------------------------------------------------------*/
    final String VER_RTKLIB = "2.4.3";             /* library version */
    final String PATCH_LEVEL= "b31";               /* patch level */
    final String COPYRIGHT_RTKLIB = "Copyright (C) 2007-2018 T.Takasu\nAll rights reserved.";

    final double PI          = 3.1415926535897932;  /* pi */
    final double D2R         = (PI/180.0);          /* deg to rad */
    final double R2D         = (180.0/PI);          /* rad to deg */
    final double CLIGHT      = 299792458.0;         /* speed of light (m/s) */
    final double SC2RAD      = 3.1415926535898;     /* semi-circle to radian (IS-GPS) */
    final double AU          = 149597870691.0;      /* 1 AU (m) */
    final double AS2R        = (D2R/3600.0)  ;      /* arc sec to radian */

    final double OMGE        = 7.2921151467E-5 ;    /* earth angular velocity (IS-GPS) (rad/s) */

    final double RE_WGS84    = 6378137.0 ;          /* earth semimajor axis (WGS84) (m) */
    final double FE_WGS84    = (1.0/298.257223563); /* earth flattening (WGS84) */

    final double HION        = 350000.0;            /* ionosphere height (m) */

    final double MAXFREQ     = 7 ;                  /* max NFREQ */

    final double FREQ1       = 1.57542E9 ;          /* L1/E1  frequency (Hz) */
    final double FREQ2       = 1.22760E9 ;          /* L2     frequency (Hz) */
    final double FREQ5       = 1.17645E9 ;          /* L5/E5a frequency (Hz) */
    final double FREQ6       = 1.27875E9 ;          /* E6/LEX frequency (Hz) */
    final double FREQ7       = 1.20714E9 ;          /* E5b    frequency (Hz) */
    final double FREQ8       = 1.191795E9;          /* E5a+b  frequency (Hz) */
    final double FREQ9       = 2.492028E9;          /* S      frequency (Hz) */
    final double FREQ1_GLO   = 1.60200E9;           /* GLONASS G1 base frequency (Hz) */
    final double DFRQ1_GLO   = 0.56250E6;           /* GLONASS G1 bias frequency (Hz/n) */
    final double FREQ2_GLO   = 1.24600E9;           /* GLONASS G2 base frequency (Hz) */
    final double DFRQ2_GLO   = 0.43750E6;           /* GLONASS G2 bias frequency (Hz/n) */
    final double FREQ3_GLO   = 1.202025E9;          /* GLONASS G3 frequency (Hz) */
    final double FREQ1_CMP   = 1.561098E9;          /* BeiDou B1 frequency (Hz) */
    final double FREQ2_CMP   = 1.20714E9;           /* BeiDou B2 frequency (Hz) */
    final double FREQ3_CMP   = 1.26852E9;           /* BeiDou B3 frequency (Hz) */

    final double EFACT_GPS   = 1.0;                 /* error factor: GPS */
    final double EFACT_GLO   = 1.5;                 /* error factor: GLONASS */
    final double EFACT_GAL   = 1.0;                 /* error factor: Galileo */
    final double EFACT_QZS   = 1.0;                 /* error factor: QZSS */
    final double EFACT_CMP   = 1.0;                 /* error factor: BeiDou */
    final double EFACT_IRN   = 1.5;                 /* error factor: IRNSS */
    final double EFACT_SBS   = 3.0;                 /* error factor: SBAS */

    final double SYS_NONE    = 0x00;                /* navigation system: none */
    final double SYS_GPS     = 0x01;                /* navigation system: GPS */
    final double SYS_SBS     = 0x02;                /* navigation system: SBAS */
    final double SYS_GLO     = 0x04;                /* navigation system: GLONASS */
    final double SYS_GAL     = 0x08;                /* navigation system: Galileo */
    final double SYS_QZS     = 0x10;                /* navigation system: QZSS */
    final double SYS_CMP     = 0x20;                /* navigation system: BeiDou */
    final double SYS_IRN     = 0x40;                /* navigation system: IRNS */
    final double SYS_LEO     = 0x80;                /* navigation system: LEO */
    final double SYS_ALL     = 0xFF;                /* navigation system: all */

    final int TSYS_GPS    = 0;                   /* time system: GPS time */
    final int TSYS_UTC    = 1;                   /* time system: UTC */
    final int TSYS_GLO    = 2;                   /* time system: GLONASS time */
    final int TSYS_GAL    = 3;                   /* time system: Galileo time */
    final int TSYS_QZS    = 4;                   /* time system: QZSS time */
    final int TSYS_CMP    = 5;                   /* time system: BeiDou time */
    final int TSYS_IRN    = 6;                   /* time system: IRNSS time */

    final int NFREQ       = 3;                   /* number of carrier frequencies */
    final int NFREQGLO    = 2;                   /* number of carrier frequencies of GLONASS */

    final int NEXOBS      = 0;                   /* number of extended obs codes */

    final int MINPRNGPS   = 1;                   /* min satellite PRN number of GPS */
    final int MAXPRNGPS   = 32;                  /* max satellite PRN number of GPS */
    final int NSATGPS     = (MAXPRNGPS-MINPRNGPS+1); /* number of GPS satellites */
    final int NSYSGPS     = 1;

    final int MINPRNGLO   = 1;                   /* min satellite slot number of GLONASS */
    final int MAXPRNGLO   = 27;                  /* max satellite slot number of GLONASS */
    final int NSATGLO     = (MAXPRNGLO-MINPRNGLO+1); /* number of GLONASS satellites */
    final int NSYSGLO     = 1;

    final int MINPRNGAL   = 1;                   /* min satellite PRN number of Galileo */
    final int MAXPRNGAL   = 36;                  /* max satellite PRN number of Galileo */
    final int NSATGAL     = (MAXPRNGAL-MINPRNGAL+1); /* number of Galileo satellites */
    final int NSYSGAL     = 1;

    final int MINPRNQZS   = 193;                 /* min satellite PRN number of QZSS */
    final int MAXPRNQZS   = 202;                 /* max satellite PRN number of QZSS */
    final int MINPRNQZS_S = 183;                 /* min satellite PRN number of QZSS SAIF */
    final int MAXPRNQZS_S = 191;                 /* max satellite PRN number of QZSS SAIF */
    final int NSATQZS     = (MAXPRNQZS-MINPRNQZS+1); /* number of QZSS satellites */
    final int NSYSQZS     = 1;

    final int MINPRNCMP   = 1;                   /* min satellite sat number of BeiDou */
    final int MAXPRNCMP   = 35;                  /* max satellite sat number of BeiDou */
    final int NSATCMP     = (MAXPRNCMP-MINPRNCMP+1); /* number of BeiDou satellites */
    final int NSYSCMP     = 1;

    final int MINPRNIRN   = 1;                   /* min satellite sat number of IRNSS */
    final int MAXPRNIRN   = 7;                   /* max satellite sat number of IRNSS */
    final int NSATIRN     = (MAXPRNIRN-MINPRNIRN+1); /* number of IRNSS satellites */
    final int NSYSIRN     = 1;

    final int MINPRNLEO   = 1;                   /* min satellite sat number of LEO */
    final int MAXPRNLEO   = 10;                  /* max satellite sat number of LEO */
    final int NSATLEO     = (MAXPRNLEO-MINPRNLEO+1); /* number of LEO satellites */
    final int NSYSLEO     = 1;

    final int NSYS        = (NSYSGPS+NSYSGLO+NSYSGAL+NSYSQZS+NSYSCMP+NSYSIRN+NSYSLEO); /* number of systems */

    final int MINPRNSBS   = 120;                 /* min satellite PRN number of SBAS */
    final int MAXPRNSBS   = 142;                 /* max satellite PRN number of SBAS */
    final int NSATSBS     = (MAXPRNSBS-MINPRNSBS+1); /* number of SBAS satellites */

    final int MAXSAT      = (NSATGPS+NSATGLO+NSATGAL+NSATQZS+NSATCMP+NSATIRN+NSATSBS+NSATLEO);
            /* max satellite number (1 to MAXSAT) */
    final int MAXSTA      = 255;


    final int MAXOBS      = 64;                  /* max number of obs in an epoch */

    final int MAXRCV      = 64;                  /* max receiver number (1 to MAXRCV) */
    final int MAXOBSTYPE  = 64;                  /* max number of obs type in RINEX */

    final double DTTOL       = 0.005;               /* tolerance of time difference (s) */

    final double MAXDTOE     = 7200.0;              /* max time difference to GPS Toe (s) */
    final double MAXDTOE_QZS = 7200.0;              /* max time difference to QZSS Toe (s) */
    final double MAXDTOE_GAL = 14400.0;             /* max time difference to Galileo Toe (s) */
    final double MAXDTOE_CMP = 21600.0;             /* max time difference to BeiDou Toe (s) */
    final double MAXDTOE_GLO = 1800.0;              /* max time difference to GLONASS Toe (s) */
    final double MAXDTOE_SBS = 360.0;               /* max time difference to SBAS Toe (s) */
    final double MAXDTOE_S   = 86400.0;             /* max time difference to ephem toe (s) for other */
    final double MAXGDOP     = 300.0;               /* max GDOP */

    final double INT_SWAP_TRAC = 86400.0;           /* swap interval of trace file (s) */
    final double INT_SWAP_STAT = 86400.0;           /* swap interval of solution status file (s) */

    final double MAXEXFILE   = 1024;                /* max number of expanded files */
    final double MAXSBSAGEF  = 30.0;                /* max age of SBAS fast correction (s) */
    final double MAXSBSAGEL  = 1800.0;              /* max age of SBAS long term corr (s) */
    final int MAXSBSURA   = 8;                   /* max URA of SBAS satellite */
    final int MAXBAND     = 10;                  /* max SBAS band of IGP */
    final int MAXNIGP     = 201;                 /* max number of IGP in SBAS band */
    final int MAXNGEO     = 4;                   /* max number of GEO satellites */
    final int MAXCOMMENT  = 10;                  /* max number of RINEX comments */
    final int MAXSTRPATH  = 1024;                /* max length of stream path */
    final int MAXSTRMSG   = 1024;                /* max length of stream message */
    final int MAXSTRRTK   = 8;                   /* max number of stream in RTK server */
    final int MAXSBSMSG   = 32;                  /* max number of SBAS msg in RTK server */
    final int MAXSOLMSG   = 8191;                /* max length of solution message */
    final int MAXRAWLEN   = 4096;                /* max length of receiver raw message */
    final int MAXERRMSG   = 4096;                /* max length of error/warning message */
    final int MAXANT      = 64;                  /* max length of station name/antenna type */
    final int MAXSOLBUF   = 256;                 /* max number of solution buffer */
    final int MAXOBSBUF   = 128;                 /* max number of observation data buffer */
    final int MAXNRPOS    = 16;                  /* max number of reference positions */
    final int MAXLEAPS    = 64;                  /* max number of leap seconds table */
    final int MAXGISLAYER = 32;                  /* max number of GIS data layers */
    final int MAXRCVCMD   = 4096;                /* max length of receiver commands */

    final double RNX2VER     = 2.10;                /* RINEX ver.2 default output version */
    final double RNX3VER     = 3.00;                /* RINEX ver.3 default output version */

    final int OBSTYPE_PR  = 0x01;                /* observation type: pseudorange */
    final int OBSTYPE_CP  = 0x02;                /* observation type: carrier-phase */
    final int OBSTYPE_DOP = 0x04;                /* observation type: doppler-freq */
    final int OBSTYPE_SNR = 0x08;                /* observation type: SNR */
    final int OBSTYPE_ALL = 0xFF;                /* observation type: all */

    final int FREQTYPE_L1 = 0x01;                /* frequency type: L1/E1 */
    final int FREQTYPE_L2 = 0x02;                /* frequency type: L2/B1 */
    final int FREQTYPE_L5 = 0x04;                /* frequency type: L5/E5a/L3 */
    final int FREQTYPE_L6 = 0x08;                /* frequency type: E6/LEX/B3 */
    final int FREQTYPE_L7 = 0x10;                /* frequency type: E5b/B2 */
    final int FREQTYPE_L8 = 0x20;                /* frequency type: E5(a+b) */
    final int FREQTYPE_L9 = 0x40;                /* frequency type: S */
    final int FREQTYPE_ALL = 0xFF;               /* frequency type: all */

    final int CODE_NONE   = 0;                   /* obs code: none or unknown */
    final int CODE_L1C    = 1;                   /* obs code: L1C/A,G1C/A,E1C (GPS,GLO,GAL,QZS,SBS) */
    final int CODE_L1P    = 2;                   /* obs code: L1P,G1P    (GPS,GLO) */
    final int CODE_L1W    = 3;                   /* obs code: L1 Z-track (GPS) */
    final int CODE_L1Y    = 4;                   /* obs code: L1Y        (GPS) */
    final int CODE_L1M    = 5;                   /* obs code: L1M        (GPS) */
    final int CODE_L1N    = 6;                   /* obs code: L1codeless (GPS) */
    final int CODE_L1S    = 7;                   /* obs code: L1C(D)     (GPS,QZS) */
    final int CODE_L1L    = 8;                   /* obs code: L1C(P)     (GPS,QZS) */
    final int CODE_L1E    = 9;                   /* (not used) */
    final int CODE_L1A    = 10;                  /* obs code: E1A        (GAL) */
    final int CODE_L1B    = 11;                  /* obs code: E1B        (GAL) */
    final int CODE_L1X    = 12;                  /* obs code: E1B+C,L1C(D+P) (GAL,QZS) */
    final int CODE_L1Z    = 13;                  /* obs code: E1A+B+C,L1SAIF (GAL,QZS) */
    final int CODE_L2C    = 14;                  /* obs code: L2C/A,G1C/A (GPS,GLO) */
    final int CODE_L2D    = 15;                  /* obs code: L2 L1C/A-(P2-P1) (GPS) */
    final int CODE_L2S    = 16;                  /* obs code: L2C(M)     (GPS,QZS) */
    final int CODE_L2L    = 17;                  /* obs code: L2C(L)     (GPS,QZS) */
    final int CODE_L2X    = 18;                  /* obs code: L2C(M+L),B1I+Q (GPS,QZS,CMP) */
    final int CODE_L2P    = 19;                  /* obs code: L2P,G2P    (GPS,GLO) */
    final int CODE_L2W    = 20;                  /* obs code: L2 Z-track (GPS) */
    final int CODE_L2Y    = 21;                  /* obs code: L2Y        (GPS) */
    final int CODE_L2M    = 22;                  /* obs code: L2M        (GPS) */
    final int CODE_L2N    = 23;                  /* obs code: L2codeless (GPS) */
    final int CODE_L5I    = 24;                  /* obs code: L5/E5aI    (GPS,GAL,QZS,SBS) */
    final int CODE_L5Q    = 25;                  /* obs code: L5/E5aQ    (GPS,GAL,QZS,SBS) */
    final int CODE_L5X    = 26;                  /* obs code: L5/E5aI+Q/L5B+C (GPS,GAL,QZS,IRN,SBS) */
    final int CODE_L7I    = 27;                  /* obs code: E5bI,B2I   (GAL,CMP) */
    final int CODE_L7Q    = 28;                  /* obs code: E5bQ,B2Q   (GAL,CMP) */
    final int CODE_L7X    = 29;                  /* obs code: E5bI+Q,B2I+Q (GAL,CMP) */
    final int CODE_L6A    = 30;                  /* obs code: E6A        (GAL) */
    final int CODE_L6B    = 31;                  /* obs code: E6B        (GAL) */
    final int CODE_L6C    = 32;                  /* obs code: E6C        (GAL) */
    final int CODE_L6X    = 33;                  /* obs code: E6B+C,LEXS+L,B3I+Q (GAL,QZS,CMP) */
    final int CODE_L6Z    = 34;                  /* obs code: E6A+B+C    (GAL) */
    final int CODE_L6S    = 35;                  /* obs code: LEXS       (QZS) */
    final int CODE_L6L    = 36;                  /* obs code: LEXL       (QZS) */
    final int CODE_L8I    = 37;                  /* obs code: E5(a+b)I   (GAL) */
    final int CODE_L8Q    = 38;                  /* obs code: E5(a+b)Q   (GAL) */
    final int CODE_L8X    = 39;                  /* obs code: E5(a+b)I+Q (GAL) */
    final int CODE_L2I    = 40;                  /* obs code: B1I        (BDS) */
    final int CODE_L2Q    = 41;                  /* obs code: B1Q        (BDS) */
    final int CODE_L6I    = 42;                  /* obs code: B3I        (BDS) */
    final int CODE_L6Q    = 43;                  /* obs code: B3Q        (BDS) */
    final int CODE_L3I    = 44;                  /* obs code: G3I        (GLO) */
    final int CODE_L3Q    = 45;                  /* obs code: G3Q        (GLO) */
    final int CODE_L3X    = 46;                  /* obs code: G3I+Q      (GLO) */
    final int CODE_L1I    = 47;                  /* obs code: B1I        (BDS) */
    final int CODE_L1Q    = 48;                  /* obs code: B1Q        (BDS) */
    final int CODE_L5A    = 49;                  /* obs code: L5A SPS    (IRN) */
    final int CODE_L5B    = 50;                  /* obs code: L5B RS(D)  (IRN) */
    final int CODE_L5C    = 51;                  /* obs code: L5C RS(P)  (IRN) */
    final int CODE_L9A    = 52;                  /* obs code: SA SPS     (IRN) */
    final int CODE_L9B    = 53;                  /* obs code: SB RS(D)   (IRN) */
    final int CODE_L9C    = 54;                  /* obs code: SC RS(P)   (IRN) */
    final int CODE_L9X    = 55;                  /* obs code: SB+C       (IRN) */
    final int MAXCODE     = 55;                  /* max number of obs code */

    final int PMODE_SINGLE = 0;                  /* positioning mode: single */
    final int PMODE_DGPS   = 1;                  /* positioning mode: DGPS/DGNSS */
    final int PMODE_KINEMA = 2;                  /* positioning mode: kinematic */
    final int PMODE_STATIC = 3;                  /* positioning mode: static */
    final int PMODE_MOVEB  = 4;                  /* positioning mode: moving-base */
    final int PMODE_FIXED  = 5;                  /* positioning mode: fixed */
    final int PMODE_PPP_KINEMA = 6;             /* positioning mode: PPP-kinemaric */
    final int PMODE_PPP_STATIC = 7;              /* positioning mode: PPP-static */
    final int PMODE_PPP_FIXED = 8;               /* positioning mode: PPP-fixed */

    final int SOLF_LLH    = 0;                   /* solution format: lat/lon/height */
    final int SOLF_XYZ    = 1;                   /* solution format: x/y/z-ecef */
    final int SOLF_ENU    = 2;                   /* solution format: e/n/u-baseline */
    final int SOLF_NMEA   = 3;                   /* solution format: NMEA-183 */
    final int SOLF_STAT   = 4;                   /* solution format: solution status */
    final int SOLF_GSIF   = 5;                   /* solution format: GSI F1/F2 */

    final int SOLQ_NONE   = 0;                   /* solution status: no solution */
    final int SOLQ_FIX    = 1;                   /* solution status: fix */
    final int SOLQ_FLOAT  = 2;                   /* solution status: float */
    final int SOLQ_SBAS   = 3;                   /* solution status: SBAS */
    final int SOLQ_DGPS   = 4;                   /* solution status: DGPS/DGNSS */
    final int SOLQ_SINGLE = 5;                   /* solution status: single */
    final int SOLQ_PPP    = 6;                   /* solution status: PPP */
    final int SOLQ_DR     = 7;                   /* solution status: dead reconing */
    final int MAXSOLQ     = 7;                   /* max number of solution status */

    final int TIMES_GPST  = 0;                   /* time system: gps time */
    final int TIMES_UTC   = 1;                   /* time system: utc */
    final int TIMES_JST   = 2;                   /* time system: jst */

    final int IONOOPT_OFF = 0;                   /* ionosphere option: correction off */
    final int IONOOPT_BRDC = 1;                  /* ionosphere option: broadcast model */
    final int IONOOPT_SBAS = 2;                  /* ionosphere option: SBAS model */
    final int IONOOPT_IFLC = 3;                  /* ionosphere option: L1/L2 or L1/L5 iono-free LC */
    final int IONOOPT_EST = 4;                   /* ionosphere option: estimation */
    final int IONOOPT_TEC = 5;                   /* ionosphere option: IONEX TEC model */
    final int IONOOPT_QZS = 6;                   /* ionosphere option: QZSS broadcast model */
    final int IONOOPT_LEX = 7;                   /* ionosphere option: QZSS LEX ionospehre */
    final int IONOOPT_STEC = 8;                  /* ionosphere option: SLANT TEC model */

    final int TROPOPT_OFF = 0;                   /* troposphere option: correction off */
    final int TROPOPT_SAAS = 1;                  /* troposphere option: Saastamoinen model */
    final int TROPOPT_SBAS = 2;                  /* troposphere option: SBAS model */
    final int TROPOPT_EST = 3;                   /* troposphere option: ZTD estimation */
    final int TROPOPT_ESTG = 4;                  /* troposphere option: ZTD+grad estimation */
    final int TROPOPT_ZTD = 5;                   /* troposphere option: ZTD correction */

    final int EPHOPT_BRDC = 0;                   /* ephemeris option: broadcast ephemeris */
    final int EPHOPT_PREC = 1;                   /* ephemeris option: precise ephemeris */
    final int EPHOPT_SBAS = 2;                   /* ephemeris option: broadcast + SBAS */
    final int EPHOPT_SSRAPC = 3;                 /* ephemeris option: broadcast + SSR_APC */
    final int EPHOPT_SSRCOM = 4;                 /* ephemeris option: broadcast + SSR_COM */
    final int EPHOPT_LEX  = 5;                   /* ephemeris option: QZSS LEX ephemeris */

    final int ARMODE_OFF  = 0;                   /* AR mode: off */
    final int ARMODE_CONT = 1;                   /* AR mode: continuous */
    final int ARMODE_INST = 2;                   /* AR mode: instantaneous */
    final int ARMODE_FIXHOLD = 3;                /* AR mode: fix and hold */
    final int ARMODE_WLNL = 4;                   /* AR mode: wide lane/narrow lane */
    final int ARMODE_TCAR = 5;                   /* AR mode: triple carrier ar */

    final int SBSOPT_LCORR = 1;                  /* SBAS option: long term correction */
    final int SBSOPT_FCORR = 2;                  /* SBAS option: fast correction */
    final int SBSOPT_ICORR = 4;                  /* SBAS option: ionosphere correction */
    final int SBSOPT_RANGE = 8;                  /* SBAS option: ranging */

    final int POSOPT_POS   = 0;                  /* pos option: LLH/XYZ */
    final int POSOPT_SINGLE = 1;                 /* pos option: average of single pos */
    final int POSOPT_FILE  = 2;                  /* pos option: read from pos file */
    final int POSOPT_RINEX = 3;                  /* pos option: rinex header pos */
    final int POSOPT_RTCM  = 4;                  /* pos option: rtcm station pos */
    final int POSOPT_RAW   = 5;                  /* pos option: raw station pos */

    final int STR_NONE     = 0;                  /* stream type: none */
    final int STR_SERIAL   = 1;                  /* stream type: serial */
    final int STR_FILE     = 2;                  /* stream type: file */
    final int STR_TCPSVR   = 3;                  /* stream type: TCP server */
    final int STR_TCPCLI   = 4;                  /* stream type: TCP client */
    final int STR_NTRIPSVR = 6;                  /* stream type: NTRIP server */
    final int STR_NTRIPCLI = 7;                  /* stream type: NTRIP client */
    final int STR_FTP      = 8;                  /* stream type: ftp */
    final int STR_HTTP     = 9;                  /* stream type: http */
    final int STR_NTRIPC_S = 10;                 /* stream type: NTRIP caster server */
    final int STR_NTRIPC_C = 11;                 /* stream type: NTRIP caster client */
    final int STR_UDPSVR   = 12;                 /* stream type: UDP server */
    final int STR_UDPCLI   = 13;                 /* stream type: UDP server */
    final int STR_MEMBUF   = 14;                 /* stream type: memory buffer */

    final int STRFMT_RTCM2 = 0;                  /* stream format: RTCM 2 */
    final int STRFMT_RTCM3 = 1;                  /* stream format: RTCM 3 */
    final int STRFMT_OEM4  = 2;                  /* stream format: NovAtel OEMV/4 */
    final int STRFMT_OEM3  = 3;                  /* stream format: NovAtel OEM3 */
    final int STRFMT_UBX   = 4;                  /* stream format: u-blox LEA-*T */
    final int STRFMT_SS2   = 5;                  /* stream format: NovAtel Superstar II */
    final int STRFMT_CRES  = 6;                  /* stream format: Hemisphere */
    final int STRFMT_STQ   = 7;                  /* stream format: SkyTraq S1315F */
    final int STRFMT_GW10  = 8;                  /* stream format: Furuno GW10 */
    final int STRFMT_JAVAD = 9;                  /* stream format: JAVAD GRIL/GREIS */
    final int STRFMT_NVS   = 10;                 /* stream format: NVS NVC08C */
    final int STRFMT_BINEX = 11;                 /* stream format: BINEX */
    final int STRFMT_RT17  = 12;                 /* stream format: Trimble RT17 */
    final int STRFMT_SEPT  = 13;                 /* stream format: Septentrio */
    final int STRFMT_CMR   = 14;                 /* stream format: CMR/CMR+ */
    final int STRFMT_TERSUS = 15;                /* stream format: TERSUS */
    final int STRFMT_LEXR  = 16;                 /* stream format: Furuno LPY-10000 */
    final int STRFMT_RINEX = 17;                 /* stream format: RINEX */
    final int STRFMT_SP3   = 18;                 /* stream format: SP3 */
    final int STRFMT_RNXCLK = 19;                /* stream format: RINEX CLK */
    final int STRFMT_SBAS  = 20;                 /* stream format: SBAS messages */
    final int STRFMT_NMEA  = 21;                 /* stream format: NMEA 0183 */
    final int MAXRCVFMT    = 15;                 /* max number of receiver format */

    final int STR_MODE_R  = 0x1;                 /* stream mode: read */
    final int STR_MODE_W  = 0x2;                 /* stream mode: write */
    final int STR_MODE_RW = 0x3;                 /* stream mode: read/write */

    final int GEOID_EMBEDDED    = 0;             /* geoid model: embedded geoid */
    final int GEOID_EGM96_M150  = 1;             /* geoid model: EGM96 15x15" */
    final int GEOID_EGM2008_M25 = 2;             /* geoid model: EGM2008 2.5x2.5" */
    final int GEOID_EGM2008_M10 = 3;             /* geoid model: EGM2008 1.0x1.0" */
    final int GEOID_GSI2000_M15 = 4;             /* geoid model: GSI geoid 2000 1.0x1.5" */
    final int GEOID_RAF09       = 5;             /* geoid model: IGN RAF09 for France 1.5"x2" */

    final String COMMENTH    = "%";                 /* comment line indicator for solution */
    final String MSG_DISCONN = "$_DISCONNECT\r\n";  /* disconnect message */

    final int DLOPT_FORCE   = 0x01;              /* download option: force download existing */
    final int DLOPT_KEEPCMP = 0x02;              /* download option: keep compressed file */
    final int DLOPT_HOLDERR = 0x04;              /* download option: hold on error file */
    final int DLOPT_HOLDLST = 0x08;              /* download option: hold on listing file */

    final int LLI_SLIP    = 0x01;                /* LLI: cycle-slip */
    final int LLI_HALFC   = 0x02;                /* LLI: half-cycle not resovled */
    final int LLI_BOCTRK  = 0x04;                /* LLI: boc tracking of mboc signal */
    final int LLI_HALFA   = 0x40;                /* LLI: half-cycle added */
    final int LLI_HALFS   = 0x80;                /* LLI: half-cycle subtracted */

    final int IMUFMT_KVH  = 1;                   /* imu data format KVH */

    final double P2_5        = 0.03125;             /* 2^-5 */
    final double P2_6        = 0.015625;            /* 2^-6 */
    final double P2_11       = 4.882812500000000E-04; /* 2^-11 */
    final double P2_15       = 3.051757812500000E-05; /* 2^-15 */
    final double P2_17       = 7.629394531250000E-06; /* 2^-17 */
    final double P2_19       = 1.907348632812500E-06; /* 2^-19 */
    final double P2_20       = 9.536743164062500E-07; /* 2^-20 */
    final double P2_21       = 4.768371582031250E-07; /* 2^-21 */
    final double P2_23       = 1.192092895507810E-07; /* 2^-23 */
    final double P2_24       = 5.960464477539063E-08; /* 2^-24 */
    final double P2_27       = 7.450580596923828E-09;/* 2^-27 */
    final double P2_29       = 1.862645149230957E-09; /* 2^-29 */
    final double P2_30       = 9.313225746154785E-10; /* 2^-30 */
    final double P2_31       = 4.656612873077393E-10; /* 2^-31 */
    final double P2_32       = 2.328306436538696E-10; /* 2^-32 */
    final double P2_33       = 1.164153218269348E-10; /* 2^-33 */
    final double P2_35       = 2.910383045673370E-11; /* 2^-35 */
    final double P2_38       = 3.637978807091710E-12; /* 2^-38 */
    final double P2_39       = 1.818989403545856E-12; /* 2^-39 */
    final double P2_40       = 9.094947017729280E-13; /* 2^-40 */
    final double P2_43       = 1.136868377216160E-13; /* 2^-43 */
    final double P2_48       = 3.552713678800501E-15; /* 2^-48 */
    final double P2_50       = 8.881784197001252E-16; /* 2^-50 */
    final double P2_55       = 2.775557561562891E-17; /* 2^-55 */

    /* type definitions ----------------------------------------------------------*/

    public class gtime_t {        /* time struct */
        Instant time;        /* time (s) expressed by standard time_t */
        double sec;         /* fraction of second under 1 s */
    };

    public class obsd_t {        /* observation data record */
        gtime_t time;       /* receiver sampling time (GPST) */
        byte sat,rcv; /* satellite/receiver number */
        byte[] SNR = new byte[NFREQ+NEXOBS]; /* signal strength (0.25 dBHz) */
        byte[] LLI = new byte [NFREQ+NEXOBS]; /* loss of lock indicator */
        byte[] code = new byte[NFREQ+NEXOBS]; /* code indicator (CODE_???) */
        double[] L = new double[NFREQ+NEXOBS]; /* observation data carrier-phase (cycle) */
        double[] P = new double[NFREQ+NEXOBS]; /* observation data pseudorange (m) */
        float[]  D = new float[NFREQ+NEXOBS]; /* observation data doppler frequency (Hz) */
    };

    public class obs_t {        /* observation data */
        int n,nmax;         /* number of obervation data/allocated */
        obsd_t data;       /* observation data records */
    } ;

    public class erpd_t {        /* earth rotation parameter data type */
        double mjd;         /* mjd (days) */
        double xp,yp;       /* pole offset (rad) */
        double xpr,ypr;     /* pole offset rate (rad/day) */
        double ut1_utc;     /* ut1-utc (s) */
        double lod;         /* length of day (s/day) */
    } ;

    public class erp_t {        /* earth rotation parameter type */
        int n,nmax;         /* number and max number of data */
        erpd_t data;       /* earth rotation parameter data */
    } ;

    public class pcv_t {        /* antenna parameter type */
        int sat;            /* satellite number (0:receiver) */
        byte[] type = new byte[MAXANT];  /* antenna type */
        byte[] code = new byte[MAXANT];  /* serial number or satellite code */
        gtime_t ts,te;      /* valid time start and end */
        double[][] off = new double[NFREQ][ 3]; /* phase center offset e/n/u or x/y/z (m) */
        double[][] var = new double[NFREQ][19]; /* phase center variation (m) */
        /* el=90,85,...,0 or nadir=0,1,2,3,... (deg) */
    } ;

    public class pcvs_t {        /* antenna parameters type */
        int n,nmax;         /* number of data/allocated */
        pcv_t pcv;         /* antenna parameters data */
    } ;

    public class alm_t {        /* almanac type */
        int sat;            /* satellite number */
        int svh;            /* sv health (0:ok) */
        int svconf;         /* as and sv config */
        int week;           /* GPS/QZS: gps week, GAL: galileo week */
        gtime_t toa;        /* Toa */
        /* SV orbit parameters */
        double A,e,i0,OMG0,omg,M0,OMGd;
        double toas;        /* Toa (s) in week */
        double f0,f1;       /* SV clock parameters (af0,af1) */
    } ;

    public class eph_t {        /* GPS/QZS/GAL broadcast ephemeris type */
        int sat;            /* satellite number */
        int iode,iodc;      /* IODE,IODC */
        int sva;            /* SV accuracy (URA index) */
        int svh;            /* SV health (0:ok) */
        int week;           /* GPS/QZS: gps week, GAL: galileo week */
        int code;           /* GPS/QZS: code on L2 */
        /* GAL: data source defined as rinex 3.03 */
        /* BDS: data source (0:unknown,1:B1I,2:B1Q,3:B2I,4:B2Q,5:B3I,6:B3Q) */
        int flag;           /* GPS/QZS: L2 P data flag */
        /* BDS: nav type (0:unknown,1:IGSO/MEO,2:GEO) */
        gtime_t toe,toc,ttr; /* Toe,Toc,T_trans */
        /* SV orbit parameters */
        double A,e,i0,OMG0,omg,M0,deln,OMGd,idot;
        double crc,crs,cuc,cus,cic,cis;
        double toes;        /* Toe (s) in week */
        double fit;         /* fit interval (h) */
        double f0,f1,f2;    /* SV clock parameters (af0,af1,af2) */
        double[] tgd = new double[4];      /* group delay parameters */
        /* GPS/QZS:tgd[0]=TGD */
        /* GAL    :tgd[0]=BGD E5a/E1,tgd[1]=BGD E5b/E1 */
        /* CMP    :tgd[0]=BGD1,tgd[1]=BGD2 */
        double Adot,ndot;   /* Adot,ndot for CNAV */
    } ;

    public class geph_t {        /* GLONASS broadcast ephemeris type */
        int sat;            /* satellite number */
        int iode;           /* IODE (0-6 bit of tb field) */
        int frq;            /* satellite frequency number */
        int svh,sva,age;    /* satellite health, accuracy, age of operation */
        gtime_t toe;        /* epoch of epherides (gpst) */
        gtime_t tof;        /* message frame time (gpst) */
        double[] pos = new double[3];      /* satellite position (ecef) (m) */
        double[] vel = new double[3];      /* satellite velocity (ecef) (m/s) */
        double[] acc = new double[3];      /* satellite acceleration (ecef) (m/s^2) */
        double taun,gamn;   /* SV clock bias (s)/relative freq bias */
        double dtaun;       /* delay between L1 and L2 (s) */
    } ;

    public class peph_t {        /* precise ephemeris type */
        gtime_t time;       /* time (GPST) */
        int index;          /* ephemeris index for multiple files */
        double[][] pos = new double[MAXSAT][4]; /* satellite position/clock (ecef) (m|s) */
        float[][]  std = new float[MAXSAT][4]; /* satellite position/clock std (m|s) */
        double[][] vel = new double[MAXSAT][4]; /* satellite velocity/clk-rate (m/s|s/s) */
        float[][]  vst = new float[MAXSAT][4]; /* satellite velocity/clk-rate std (m/s|s/s) */
        float[][]  cov = new float[MAXSAT][3]; /* satellite position covariance (m^2) */
        float[][]  vco = new float[MAXSAT][3]; /* satellite velocity covariance (m^2) */
    } ;

    public class pclk_t {        /* precise clock type */
        gtime_t time;       /* time (GPST) */
        int index;          /* clock index for multiple files */
        double[][] clk = new double[MAXSAT][1]; /* satellite clock (s) */
        float[][]  std = new float[MAXSAT][1]; /* satellite clock std (s) */
    } ;

    public class seph_t {        /* SBAS ephemeris type */
        int sat;            /* satellite number */
        gtime_t t0;         /* reference epoch time (GPST) */
        gtime_t tof;        /* time of message frame (GPST) */
        int sva;            /* SV accuracy (URA index) */
        int svh;            /* SV health (0:ok) */
        double[] pos = new double[3];      /* satellite position (m) (ecef) */
        double[] vel = new double[3];      /* satellite velocity (m/s) (ecef) */
        double[] acc = new double[3];      /* satellite acceleration (m/s^2) (ecef) */
        double af0,af1;     /* satellite clock-offset/drift (s,s/s) */
    } ;

    public class tled_t {        /* norad two line element data type */
        byte[] name  = new byte[32];     /* common name */
        byte[] alias = new byte[32];     /* alias name */
        byte[] satno = new byte[16];     /* satellilte catalog number */
        char satclass;      /* classification */
        byte[] desig = new byte[16];     /* international designator */
        gtime_t epoch;      /* element set epoch (UTC) */
        double ndot;        /* 1st derivative of mean motion */
        double nddot;       /* 2st derivative of mean motion */
        double bstar;       /* B* drag term */
        int etype;          /* element set type */
        int eleno;          /* element number */
        double inc;         /* orbit inclination (deg) */
        double OMG;         /* right ascension of ascending node (deg) */
        double ecc;         /* eccentricity */
        double omg;         /* argument of perigee (deg) */
        double M;           /* mean anomaly (deg) */
        double n;           /* mean motion (rev/day) */
        int rev;            /* revolution number at epoch */
    } ;

    public class tle_t {        /* norad two line element type */
        int n,nmax;         /* number/max number of two line element data */
        tled_t data;       /* norad two line element data */
    } ;

    public class tec_t {        /* TEC grid type */
        gtime_t time;       /* epoch time (GPST) */
        int[] ndata = new int[3];       /* TEC grid data size {nlat,nlon,nhgt} */
        double rb;          /* earth radius (km) */
        double[] lats = new double[3];     /* latitude start/interval (deg) */
        double[] lons = new double[3];     /* longitude start/interval (deg) */
        double[] hgts = new double[3];     /* heights start/interval (km) */
        double data;       /* TEC grid data (tecu) */
        float rms;         /* RMS values (tecu) */
    } ;

    public class fcbd_t {        /* satellite fcb data type */
        gtime_t ts,te;      /* start/end time (GPST) */
        double[][] bias = new double[MAXSAT][3]; /* fcb value   (cyc) */
        double[][] std  = new double[MAXSAT][3]; /* fcb std-dev (cyc) */
    } ;

    public class sbsmsg_t {        /* SBAS message type */
        int week,tow;       /* receiption time */
        int prn;            /* SBAS satellite PRN number */
        char[] msg = new char[29]; /* SBAS message (226bit) padded by 0 */
    } ;

    public class sbs_t {        /* SBAS messages type */
        int n,nmax;         /* number of SBAS messages/allocated */
        sbsmsg_t msgs;     /* SBAS messages */
    } ;

    public class sbsfcorr_t {        /* SBAS fast correction type */
        gtime_t t0;         /* time of applicability (TOF) */
        double prc;         /* pseudorange correction (PRC) (m) */
        double rrc;         /* range-rate correction (RRC) (m/s) */
        double dt;          /* range-rate correction delta-time (s) */
        int iodf;           /* IODF (issue of date fast corr) */
        short udre;         /* UDRE+1 */
        short ai;           /* degradation factor indicator */
    } ;

    public class sbslcorr_t {        /* SBAS long term satellite error correction type */
        gtime_t t0;         /* correction time */
        int iode;           /* IODE (issue of date ephemeris) */
        double[] dpos = new double[3];     /* delta position (m) (ecef) */
        double[] dvel = new double[3];     /* delta velocity (m/s) (ecef) */
        double daf0,daf1;   /* delta clock-offset/drift (s,s/s) */
    } ;

    public class sbssatp_t {        /* SBAS satellite correction type */
        int sat;            /* satellite number */
        sbsfcorr_t fcorr;   /* fast correction */
        sbslcorr_t lcorr;   /* long term correction */
    } ;

    public class sbssat_t {        /* SBAS satellite corrections type */
        int iodp;           /* IODP (issue of date mask) */
        int nsat;           /* number of satellites */
        int tlat;           /* system latency (s) */
        sbssatp_t[] sat = new sbssatp_t[MAXSAT]; /* satellite correction */
    } ;

    public class sbsigp_t {        /* SBAS ionospheric correction type */
        gtime_t t0;         /* correction time */
        short lat,lon;      /* latitude/longitude (deg) */
        short give;         /* GIVI+1 */
        float delay;        /* vertical delay estimate (m) */
    } ;

    public class sbsigpband_t {        /* IGP band type */
        short x;            /* longitude/latitude (deg) */
        short y;     /* latitudes/longitudes (deg) */
        byte bits; /* IGP mask start bit */
        byte bite; /* IGP mask end bit */
    } ;

    public class sbsion_t {        /* SBAS ionospheric corrections type */
        int iodi;           /* IODI (issue of date ionos corr) */
        int nigp;           /* number of igps */
        sbsigp_t[] igp = new sbsigp_t[MAXNIGP]; /* ionospheric correction */
    } ;

    public class dgps_t {        /* DGPS/GNSS correction type */
        gtime_t t0;         /* correction time */
        double prc;         /* pseudorange correction (PRC) (m) */
        double rrc;         /* range rate correction (RRC) (m/s) */
        int iod;            /* issue of data (IOD) */
        double udre;        /* UDRE */
    } ;

    public class ssr_t {        /* SSR correction type */
        gtime_t[] t0 = new gtime_t[6];      /* epoch time (GPST) {eph,clk,hrclk,ura,bias,pbias} */
        double[] udi = new double[6];      /* SSR update interval (s) */
        int[] iod = new int[6];         /* iod ssr {eph,clk,hrclk,ura,bias,pbias} */
        int iode;           /* issue of data */
        int iodcrc;         /* issue of data crc for beidou/sbas */
        int ura;            /* URA indicator */
        int refd;           /* sat ref datum (0:ITRF,1:regional) */
        double[] deph = new double[3];    /* delta orbit {radial,along,cross} (m) */
        double[] ddeph = new double[3];    /* dot delta orbit {radial,along,cross} (m/s) */
        double[] dclk = new double[3];    /* delta clock {c0,c1,c2} (m,m/s,m/s^2) */
        double hrclk;       /* high-rate clock corection (m) */
        float[]  cbias = new float[MAXCODE]; /* code biases (m) */
        double[] pbias = new double[MAXCODE]; /* phase biases (m) */
        float[]  stdpb = new float[MAXCODE]; /* std-dev of phase biases (m) */
        double yaw_ang,yaw_rate; /* yaw angle and yaw rate (deg,deg/s) */
        byte update; /* update flag (0:no update,1:update) */
    } ;

    public class lexmsg_t {        /* QZSS LEX message type */
        int prn;            /* satellite PRN number */
        int type;           /* message type */
        int alert;          /* alert flag */
        byte stat; /* signal tracking status */
        byte snr;  /* signal C/N0 (0.25 dBHz) */
        long ttt;   /* tracking time (ms) */
        byte[] msg = new byte[212]; /* LEX message data part 1695 bits */
    } ;

    public class lex_t {        /* QZSS LEX messages type */
        int n,nmax;         /* number of LEX messages and allocated */
        lexmsg_t msgs;     /* LEX messages */
    } ;

    public class lexeph_t {        /* QZSS LEX ephemeris type */
        gtime_t toe;        /* epoch time (GPST) */
        gtime_t tof;        /* message frame time (GPST) */
        int sat;            /* satellite number */
        byte health; /* signal health (L1,L2,L1C,L5,LEX) */
        byte ura;  /* URA index */
        double[] pos = new double[3];      /* satellite position (m) */
        double[] vel = new double[3];      /* satellite velocity (m/s) */
        double[] acc = new double[3];      /* satellite acceleration (m/s2) */
        double[] jerk = new double[3];     /* satellite jerk (m/s3) */
        double af0,af1;     /* satellite clock bias and drift (s,s/s) */
        double tgd;         /* TGD */
        double[] isc = new double[8];      /* ISC */
    } ;

    public class lexion_t {        /* QZSS LEX ionosphere correction type */
        gtime_t t0;         /* epoch time (GPST) */
        double tspan;       /* valid time span (s) */
        double[] pos0 = new double[2];     /* reference position {lat,lon} (rad) */
        double[][] coef = new double[3][2];  /* coefficients lat x lon (3 x 2) */
    } ;

    public class stec_t {        /* stec data type */
        gtime_t time;       /* time (GPST) */
        byte sat;  /* satellite number */
        double ion;         /* slant ionos delay (m) */
        float std;          /* std-dev (m) */
        float[] azel = new float[2];      /* azimuth/elevation (rad) */
        byte flag; /* fix flag */
    } ;

    public class trop_t {        /* trop data type */
        gtime_t time;       /* time (GPST) */
        double[] trp = new double[3];      /* zenith tropos delay/gradient (m) */
        float[] std = new float[3];       /* std-dev (m) */
    } ;

    public class pppcorr_t {        /* ppp corrections type */
        int nsta;           /* number of stations */
        char[][] stas = new char[MAXSTA][8]; /* station names */
        double[][] rr = new double[MAXSTA][3]; /* station ecef positions (m) */
        int[] ns = new int[MAXSTA];
        int[] nsmax = new int[MAXSTA]; /* number of stec data */
        int[] nt = new int[MAXSTA];
        int[] ntmax = new int[MAXSTA]; /* number of trop data */
        List<stec_t[]> stec = new ArrayList<stec_t[]>(); /* stec data with size [MAXSTA] */
        List<trop_t[]> trop = new ArrayList<trop_t[]>(); /* trop data with size [MAXSTA] */
    } ;

    public class nav_t {        /* navigation data type */
        int n,nmax;         /* number of broadcast ephemeris */
        int ng,ngmax;       /* number of glonass ephemeris */
        int ns,nsmax;       /* number of sbas ephemeris */
        int ne,nemax;       /* number of precise ephemeris */
        int nc,ncmax;       /* number of precise clock */
        int na,namax;       /* number of almanac data */
        int nt,ntmax;       /* number of tec grid data */
        int nf,nfmax;       /* number of satellite fcb data */
        List<eph_t> eph = new ArrayList<eph_t>();         /* GPS/QZS/GAL ephemeris */
        List<geph_t> geph = new ArrayList<geph_t>();      /* GLONASS ephemeris */
        List<seph_t> seph;       /* SBAS ephemeris */
        List<peph_t> peph;       /* precise ephemeris */
        List<pclk_t> pclk;       /* precise clock */
        List<alm_t> alm;         /* almanac data */
        List<tec_t> tec;         /* tec grid data */
        List<fcbd_t> fcb;        /* satellite fcb data */
        erp_t  erp;         /* earth rotation parameters */
        double[] utc_gps = new double[4];  /* GPS delta-UTC parameters {A0,A1,T,W} */
        double[] utc_glo = new double[4];  /* GLONASS UTC GPS time parameters */
        double[] utc_gal = new double[4];  /* Galileo UTC GPS time parameters */
        double[] utc_qzs = new double[4];  /* QZS UTC GPS time parameters */
        double[] utc_cmp = new double[4];  /* BeiDou UTC parameters */
        double[] utc_irn = new double[4];  /* IRNSS UTC parameters */
        double[] utc_sbs = new double[4];  /* SBAS UTC parameters */
        double[] ion_gps = new double[8];  /* GPS iono model parameters {a0,a1,a2,a3,b0,b1,b2,b3} */
        double[] ion_gal = new double[4];  /* Galileo iono model parameters {ai0,ai1,ai2,0} */
        double[] ion_qzs = new double[8];  /* QZSS iono model parameters {a0,a1,a2,a3,b0,b1,b2,b3} */
        double[] ion_cmp = new double[8];  /* BeiDou iono model parameters {a0,a1,a2,a3,b0,b1,b2,b3} */
        double[] ion_irn = new double[8];  /* IRNSS iono model parameters {a0,a1,a2,a3,b0,b1,b2,b3} */
        int leaps;          /* leap seconds (s) */
        double[][] lam = new double[MAXSAT][NFREQ]; /* carrier wave lengths (m) */
        double[][] cbias = new double[MAXSAT][3]; /* satellite dcb (0:p1-p2,1:p1-c1,2:p2-c2) (m) */
        double[][][] rbias = new double[MAXRCV][2][3]; /* receiver dcb (0:p1-p2,1:p1-c1,2:p2-c2) (m) */
        double[] wlbias = new double[MAXSAT];   /* wide-lane bias (cycle) */
        double[] glo_cpbias = new double[4];    /* glonass code-phase bias {1C,1P,2C,2P} (m) */
        char[] glo_fcn = new char[MAXPRNGLO+1]; /* glonass frequency channel number + 8 */
        pcv_t[] pcvs = new pcv_t[MAXSAT]; /* satellite antenna pcv */
        sbssat_t sbssat;    /* SBAS satellite corrections */
        sbsion_t[] sbsion = new sbsion_t[MAXBAND+1]; /* SBAS ionosphere corrections */
        dgps_t[] dgps = new dgps_t[MAXSAT]; /* DGPS corrections */
        ssr_t[] ssr = new ssr_t[MAXSAT];  /* SSR corrections */
        lexeph_t[] lexeph = new lexeph_t[MAXSAT]; /* LEX ephemeris */
        lexion_t lexion;    /* LEX ionosphere correction */
        pppcorr_t pppcorr;  /* ppp corrections */
    } ;

    public class sta_t {        /* station parameter type */
        char[] name   = new char[MAXANT]; /* marker name */
        char[] marker = new char[MAXANT]; /* marker number */
        char[] antdes = new char[MAXANT]; /* antenna descriptor */
        char[] antsno = new char[MAXANT]; /* antenna serial number */
        char[] rectype= new char[MAXANT]; /* receiver type descriptor */
        char[] recver = new char[MAXANT]; /* receiver firmware version */
        char[] recsno = new char[MAXANT]; /* receiver serial number */
        int antsetup;       /* antenna setup id */
        int itrf;           /* ITRF realization year */
        int deltype;        /* antenna delta type (0:enu,1:xyz) */
        double[] pos = new double[3];      /* station position (ecef) (m) */
        double[] del = new double[3];      /* antenna position delta (e/n/u or x/y/z) (m) */
        double hgt;         /* antenna height (m) */
    } ;

    public class sol_t {        /* solution type */
        gtime_t time;       /* time (GPST) */
        double[] rr = new double[6];       /* position/velocity (m|m/s) */
        /* {x,y,z,vx,vy,vz} or {e,n,u,ve,vn,vu} */
        float[]  qr = new float[6];       /* position variance/covariance (m^2) */
        /* {c_xx,c_yy,c_zz,c_xy,c_yz,c_zx} or */
        /* {c_ee,c_nn,c_uu,c_en,c_nu,c_ue} */
        float[]  qv = new float[6];       /* velocity variance/covariance (m^2/s^2) */
        double[] dtr = new double[6];      /* receiver clock bias to time systems (s) */
        byte type; /* type (0:xyz-ecef,1:enu-baseline) */
        byte stat; /* solution status (SOLQ_???) */
        byte ns;   /* number of valid satellites */
        float age;          /* age of differential (s) */
        float ratio;        /* AR ratio factor for valiation */
        float thres;        /* AR ratio threshold for valiation */
    } ;

    public class solbuf_t {        /* solution buffer type */
        int n,nmax;         /* number of solution/max number of buffer */
        int cyclic;         /* cyclic buffer flag */
        int start,end;      /* start/end index */
        gtime_t time;       /* current solution time */
        List<sol_t> data = new ArrayList<sol_t>();        /* solution data */
        double[] rb= new double[3];       /* reference position {x,y,z} (ecef) (m) */
        byte[] buff = new byte[MAXSOLMSG+1]; /* message buffer */
        int nb;             /* number of byte in message buffer */
    } ;

    public class solstat_t {        /* solution status type */
        gtime_t time;       /* time (GPST) */
        byte sat;  /* satellite number */
        byte frq;  /* frequency (1:L1,2:L2,...) */
        float az,el;        /* azimuth/elevation angle (rad) */
        float resp;         /* pseudorange residual (m) */
        float resc;         /* carrier-phase residual (m) */
        byte flag; /* flags: (vsat<<5)+(slip<<3)+fix */
        byte snr;  /* signal strength (0.25 dBHz) */
        int lock;  /* lock counter */
        int outc;  /* outage counter */
        int slipc; /* slip counter */
        int rejc;  /* reject counter */
    } ;

    public class solstatbuf_t {        /* solution status buffer type */
        int n,nmax;         /* number of solution/max number of buffer */
        solstat_t data;    /* solution status data */
    } ;

    public class rtcm_t {        /* RTCM control struct type */
        int staid;          /* station id */
        int stah;           /* station health */
        int seqno;          /* sequence number for rtcm 2 or iods msm */
        int outtype;        /* output message type */
        gtime_t time;       /* message time */
        gtime_t time_s;     /* message start time */
        obs_t obs;          /* observation data (uncorrected) */
        nav_t nav;          /* satellite ephemerides */
        sta_t sta;          /* station parameters */
        List<dgps_t> dgps = new ArrayList<>();       /* output of dgps corrections */
        ssr_t[] ssr = new ssr_t[MAXSAT];  /* output of ssr corrections */
        char[] msg = new char[128];      /* special message */
        char[] msgtype = new char[256];  /* last message type */
        char[][] msmtype = new char[6][128]; /* msm signal types */
        int obsflag;        /* obs data complete flag (1:ok,0:not complete) */
        int ephsat;         /* update satellite of ephemeris */
        double[][] cp = new double[MAXSAT][NFREQ+NEXOBS]; /* carrier-phase measurement */
        int[][] lock = new int[MAXSAT][NFREQ+NEXOBS]; /* lock time */
        int[][] loss = new int[MAXSAT][NFREQ+NEXOBS]; /* loss of lock count */
        gtime_t[][] lltime = new gtime_t[MAXSAT][NFREQ+NEXOBS]; /* last lock time */
        int nbyte;          /* number of bytes in message buffer */
        int nbit;           /* number of bits in word buffer */
        int len;            /* message length (bytes) */
        byte[] buff = new byte[1200]; /* message buffer */
        long word;  /* word buffer for rtcm 2 */
        long[] nmsg2 = new long[100]; /* message count of RTCM 2 (1-99:1-99,0:other) */
        long[] nmsg3 = new long[400]; /* message count of RTCM 3 (1-299:1001-1299,300-399:2000-2099,0:ohter) */
        char[] opt = new char[256];      /* RTCM dependent options */
    } ;

    public class rnxctr_t {        /* rinex control struct type */
        gtime_t time;       /* message time */
        double ver;         /* rinex version */
        char   type;        /* rinex file type ('O','N',...) */
        int    sys;         /* navigation system */
        int    tsys;        /* time system */
        char[][][]   tobs = new char[7][MAXOBSTYPE][4]; /* rinex obs types */
        obs_t  obs;         /* observation data */
        nav_t  nav;         /* navigation data */
        sta_t  sta;         /* station info */
        int    ephsat;      /* ephemeris satellite number */
        char[]   opt = new char[256];    /* rinex dependent options */
    } ;

    public class url_t {        /* download url type */
        char[] type = new char[32];      /* data type */
        char[] path = new char[1024];    /* url path */
        char[] dir = new char[1024];    /* local directory */
        double tint;        /* time interval (s) */
    } ;

    public class opt_t {        /* option type */
        final String name = new String();   /* option name */
        int format;         /* option format (0:int,1:double,2:string,3:enum) */
        // todo: Need to find the type
        // void *var;          /* pointer to option variable */
        final String comment = new String(); /* option comment/enum labels/unit */
    } ;

    public class exterr_t {        /* extended receiver error model */
        int[] ena = new int[4];         /* model enabled */
        double[][] cerr = new double[4][NFREQ*2]; /* code errors (m) */
        double[][] perr = new double[4][NFREQ*2]; /* carrier-phase errors (m) */
        double[] gpsglob = new double[NFREQ]; /* gps-glonass h/w bias (m) */
        double[] gloicb = new double [NFREQ]; /* glonass interchannel bias (m/fn) */
    } ;

    public class snrmask_t {        /* SNR mask type */
        int[] ena = new int[2];         /* enable flag {rover,base} */
        double[][] mask = new double[NFREQ][9]; /* mask (dBHz) at 5,10,...85 deg */
    } ;

    public class prcopt_t {        /* processing options type */
        int mode;           /* positioning mode (PMODE_???) */
        int soltype;        /* solution type (0:forward,1:backward,2:combined) */
        int nf;             /* number of frequencies (1:L1,2:L1+L2,3:L1+L2+L5) */
        int navsys;         /* navigation system */
        double elmin;       /* elevation mask angle (rad) */
        snrmask_t snrmask;  /* SNR mask */
        int sateph;         /* satellite ephemeris/clock (EPHOPT_???) */
        int modear;         /* AR mode (0:off,1:continuous,2:instantaneous,3:fix and hold,4:ppp-ar) */
        int glomodear;      /* GLONASS AR mode (0:off,1:on,2:auto cal,3:ext cal) */
        int bdsmodear;      /* BeiDou AR mode (0:off,1:on) */
        int maxout;         /* obs outage count to reset bias */
        int minlock;        /* min lock count to fix ambiguity */
        int minfix;         /* min fix count to hold ambiguity */
        int armaxiter;      /* max iteration to resolve ambiguity */
        int ionoopt;        /* ionosphere option (IONOOPT_???) */
        int tropopt;        /* troposphere option (TROPOPT_???) */
        int dynamics;       /* dynamics model (0:none,1:velociy,2:accel) */
        int tidecorr;       /* earth tide correction (0:off,1:solid,2:solid+otl+pole) */
        int niter;          /* number of filter iteration */
        int codesmooth;     /* code smoothing window size (0:none) */
        int intpref;        /* interpolate reference obs (for post mission) */
        int sbascorr;       /* SBAS correction options */
        int sbassatsel;     /* SBAS satellite selection (0:all) */
        int rovpos;         /* rover position for fixed mode */
        int refpos;         /* base position for relative mode */
        /* (0:pos in prcopt,  1:average of single pos, */
        /*  2:read from file, 3:rinex header, 4:rtcm pos) */
        double[] eratio = new double[NFREQ]; /* code/phase error ratio */
        double[] err = new double[5];      /* measurement error factor */
        /* [0]:reserved */
        /* [1-3]:error factor a/b/c of phase (m) */
        /* [4]:doppler frequency (hz) */
        double[] std = new double[3];      /* initial-state std [0]bias,[1]iono [2]trop */
        double[] prn = new double[6];      /* process-noise std [0]bias,[1]iono [2]trop [3]acch [4]accv [5] pos */
        double sclkstab;    /* satellite clock stability (sec/sec) */
        double[] thresar = new double[8];  /* AR validation threshold */
        double elmaskar;    /* elevation mask of AR for rising satellite (deg) */
        double elmaskhold;  /* elevation mask to hold ambiguity (deg) */
        double thresslip;   /* slip threshold of geometry-free phase (m) */
        double maxtdiff;    /* max difference of time (sec) */
        double maxinno;     /* reject threshold of innovation (m) */
        double maxgdop;     /* reject threshold of gdop */
        double[] baseline = new double[2]; /* baseline length constraint {const,sigma} (m) */
        double[] ru = new double[3];       /* rover position for fixed mode {x,y,z} (ecef) (m) */
        double[] rb = new double[3];       /* base position for relative mode {x,y,z} (ecef) (m) */
        char[][] anttype = new char[2][MAXANT]; /* antenna types {rover,base} */
        double[][] antdel = new double[2][3]; /* antenna delta {{rov_e,rov_n,rov_u},{ref_e,ref_n,ref_u}} */
        pcv_t[] pcvr = new pcv_t[2];      /* receiver antenna parameters {rov,base} */
        byte[] exsats = new byte[MAXSAT]; /* excluded satellites (1:excluded,2:included) */
        int  maxaveep;      /* max averaging epoches */
        int  initrst;       /* initialize by restart */
        int  outsingle;     /* output single by dgps/float/fix/ppp outage */
        char[][] rnxopt = new char[2][256]; /* rinex options {rover,base} */
        int[]  posopt = new int[6];     /* positioning options */
        int  syncsol;       /* solution sync mode (0:off,1:on) */
        double[][] odisp = new double[2][6*11]; /* ocean tide loading parameters {rov,base} */
        exterr_t exterr;    /* extended receiver error model */
        int freqopt;        /* disable L2-AR */
        char[] pppopt = new char[256];   /* ppp option */
    } ;

    public class solopt_t {        /* solution options type */
        int posf;           /* solution format (SOLF_???) */
        int times;          /* time system (TIMES_???) */
        int timef;          /* time format (0:sssss.s,1:yyyy/mm/dd hh:mm:ss.s) */
        int timeu;          /* time digits under decimal point */
        int degf;           /* latitude/longitude format (0:ddd.ddd,1:ddd mm ss) */
        int outhead;        /* output header (0:no,1:yes) */
        int outopt;         /* output processing options (0:no,1:yes) */
        int outvel;         /* output velocity options (0:no,1:yes) */
        int datum;          /* datum (0:WGS84,1:Tokyo) */
        int height;         /* height (0:ellipsoidal,1:geodetic) */
        int geoid;          /* geoid model (0:EGM96,1:JGD2000) */
        int solstatic;      /* solution of static mode (0:all,1:single) */
        int sstat;          /* solution statistics level (0:off,1:states,2:residuals) */
        int trace;          /* debug trace level (0:off,1-5:debug) */
        double[] nmeaintv = new double[2]; /* nmea output interval (s) (<0:no,0:all) */
        /* nmeaintv[0]:gprmc,gpgga,nmeaintv[1]:gpgsv */
        char[] sep = new char[64];       /* field separator */
        char[] prog = new char[64];      /* program name */
        double maxsolstd;   /* max std-dev for solution output (m) (0:all) */
    } ;

    public class filopt_t {        /* file options type */
        char[] satantp = new char[MAXSTRPATH]; /* satellite antenna parameters file */
        char[] rcvantp = new char[MAXSTRPATH]; /* receiver antenna parameters file */
        char[] stapos  = new char[MAXSTRPATH]; /* station positions file */
        char[] geoid   = new char[MAXSTRPATH]; /* external geoid data file */
        char[] iono    = new char[MAXSTRPATH]; /* ionosphere data file */
        char[] dcb     = new char[MAXSTRPATH]; /* dcb data file */
        char[] eop     = new char[MAXSTRPATH]; /* eop data file */
        char[] blq     = new char[MAXSTRPATH]; /* ocean tide loading blq file */
        char[] tempdir = new char[MAXSTRPATH]; /* ftp/http temporaly directory */
        char[] geexe   = new char[MAXSTRPATH]; /* google earth exec file */
        char[] solstat = new char[MAXSTRPATH]; /* solution statistics file */
        char[] trace   = new char[MAXSTRPATH]; /* debug trace file */
    } ;

    public class rnxopt_t {        /* RINEX options type */
        gtime_t ts,te;      /* time start/end */
        double tint;        /* time interval (s) */
        double ttol;        /* time tolerance (s) */
        double tunit;       /* time unit for multiple-session (s) */
        double rnxver;      /* RINEX version */
        int navsys;         /* navigation system */
        int obstype;        /* observation type */
        int freqtype;       /* frequency type */
        char[][] mask = new char[7][64];   /* code mask {GPS,GLO,GAL,QZS,SBS,CMP,IRN} */
        char[] staid  = new char[32];    /* station id for rinex file name */
        char[] prog   = new char[32];    /* program */
        char[] runby  = new char[32];    /* run-by */
        char[] marker = new char[64];    /* marker name */
        char[] markerno = new char[32];  /* marker number */
        char[] markertype = new char[32]; /* marker type (ver.3) */
        char[][] name = new char[2][32];   /* observer/agency */
        char[][] rec  = new char[3][32];   /* receiver #/type/vers */
        char[][] ant  = new char[3][32];   /* antenna #/type */
        double[] apppos = new double[3];   /* approx position x/y/z */
        double[] antdel = new double[3];   /* antenna delta h/e/n */
        char[][] comment = new char[MAXCOMMENT][64]; /* comments */
        char[] rcvopt = new char[256];   /* receiver dependent options */
        byte[] exsats = new byte[MAXSAT]; /* excluded satellites */
        int scanobs;        /* scan obs types */
        int outiono;        /* output iono correction */
        int outtime;        /* output time system correction */
        int outleaps;       /* output leap seconds */
        int autopos;        /* auto approx position */
        int halfcyc;        /* half cycle correction */
        int sep_nav;        /* separated nav files */
        gtime_t tstart;     /* first obs time */
        gtime_t tend;       /* last obs time */
        gtime_t trtcm;      /* approx log start time for rtcm */
        char[][][] tobs = new char[7][MAXOBSTYPE][4]; /* obs types {GPS,GLO,GAL,QZS,SBS,CMP,IRN} */
        int[] nobs = new int[7];        /* number of obs types {GPS,GLO,GAL,QZS,SBS,CMP,IRN} */
    } ;

    public class ssat_t {        /* satellite status type */
        byte sys;  /* navigation system */
        byte vs;   /* valid satellite flag single */
        double[] azel = new double[2];     /* azimuth/elevation angles {az,el} (rad) */
        double[] resp = new double[NFREQ]; /* residuals of pseudorange (m) */
        double[] resc = new double[NFREQ]; /* residuals of carrier-phase (m) */
        byte[] vsat = new byte[NFREQ]; /* valid satellite flag */
        byte[] snr = new byte[NFREQ]; /* signal strength (0.25 dBHz) */
        byte[] fix = new byte[NFREQ]; /* ambiguity fix flag (1:fix,2:float,3:hold) */
        byte[] slip = new byte[NFREQ]; /* cycle-slip flag */
        byte[] half = new byte[NFREQ]; /* half-cycle valid flag */
        int[] lock = new int[NFREQ];   /* lock counter of phase */
        long[] outc = new long[NFREQ]; /* obs outage counter of phase */
        long[] slipc = new long[NFREQ]; /* cycle-slip counter */
        long[] rejc = new long[NFREQ]; /* reject counter */
        double  gf;         /* geometry-free phase L1-L2 (m) */
        double  gf2;        /* geometry-free phase L1-L5 (m) */
        double  mw;         /* MW-LC (m) */
        double  phw;        /* phase windup (cycle) */
        gtime_t[][] pt = new gtime_t[2][NFREQ]; /* previous carrier-phase time */
        double[][]  ph = new double[2][NFREQ]; /* previous carrier-phase observable (cycle) */
    } ;

    public class ambc_t {        /* ambiguity control type */
        gtime_t[] epoch = new gtime_t[4];   /* last epoch */
        int[] n = new int[4];           /* number of epochs */
        double[] LC = new double[4];      /* linear combination average */
        double[] LCv = new double[4];      /* linear combination variance */
        int fixcnt;         /* fix count */
        char[] flags = new char[MAXSAT]; /* fix flags */
    } ;

    public class rtk_t {        /* RTK control/result type */
        sol_t  sol;         /* RTK solution */
        double[] rb = new double[6];       /* base position/velocity (ecef) (m|m/s) */
        int nx,na;          /* number of float states/fixed states */
        double tt;          /* time difference between current and previous (s) */
        List<Double> x = new ArrayList<Double>();
        List<Double> P = new ArrayList<Double>();      /* float states and their covariance */
        List<Double> xa = new ArrayList<Double>();
        List<Double> Pa = new ArrayList<Double>();     /* fixed states and their covariance */
        int nfix;           /* number of continuous fixes of ambiguity */
        ambc_t[] ambc = new ambc_t[MAXSAT]; /* ambibuity control */
        ssat_t[] ssat = new ssat_t[MAXSAT]; /* satellite status */
        int neb;            /* bytes in error message buffer */
        char[] errbuf = new char[MAXERRMSG]; /* error message buffer */
        prcopt_t opt;       /* processing options */
    } ;

    public class half_cyc_t {  /* half-cycle correction list type */
        byte sat;  /* satellite number */
        byte freq; /* frequency number (0:L1,1:L2,2:L5) */
        byte valid; /* half-cycle valid flag */
        char corr;          /* half-cycle corrected (x 0.5 cyc) */
        gtime_t ts,te;      /* time start, time end */
        // todo: I think this was double linked list
        half_cyc_t next; /* pointer to next correction */
    } ;

    public class raw_t {        /* receiver raw data control type */
        gtime_t time;       /* message time */
        gtime_t[][] tobs = new gtime_t[MAXSAT][NFREQ+NEXOBS]; /* observation data time */
        obs_t obs;          /* observation data */
        obs_t obuf;         /* observation data buffer */
        nav_t nav;          /* satellite ephemerides */
        sta_t sta;          /* station parameters */
        int ephsat;         /* sat number of update ephemeris (0:no satellite) */
        sbsmsg_t sbsmsg;    /* SBAS message */
        char[] msgtype = new char[256];  /* last message type */
        byte[][] subfrm = new byte[MAXSAT][380];  /* subframe buffer */
        lexmsg_t lexmsg;    /* LEX message */
        double[][] lockt = new double[MAXSAT][NFREQ+NEXOBS]; /* lock time (s) */
        double[] icpp = new double[MAXSAT],off = new double[MAXSAT],icpc; /* carrier params for ss2 */
        double[] prCA = new double[MAXSAT],dpCA = new double[MAXSAT]; /* L1/CA pseudrange/doppler for javad */
        byte[][] halfc = new byte[MAXSAT][NFREQ+NEXOBS]; /* half-cycle add flag */
        char[] freqn = new char[MAXOBS]; /* frequency number for javad */
        int nbyte;          /* number of bytes in message buffer */
        int len;            /* message length (bytes) */
        int iod;            /* issue of data */
        int tod;            /* time of day (ms) */
        int tbase;          /* time base (0:gpst,1:utc(usno),2:glonass,3:utc(su) */
        int flag;           /* general purpose flag */
        int outtype;        /* output message type */
        char[] buff = new char[MAXRAWLEN]; /* message buffer */
        char[] opt = new char[256];      /* receiver dependent options */
        List<half_cyc_t> half_cyc = new ArrayList<half_cyc_t>(); /* half-cycle correction list */

        int format;         /* receiver stream format */
        // todo: Find out data type of this argument
        // void *rcv_data;     /* receiver dependent data */
    } ;

    public class stream_t {        /* stream type */
        int type;           /* type (STR_???) */
        int mode;           /* mode (STR_MODE_?) */
        int state;          /* state (-1:error,0:close,1:open) */
        int inb,inr;   /* input bytes/rate */
        int outb,outr; /* output bytes/rate */
        int tick_i; /* input tick tick */
        int tick_o; /* output tick */
        int tact;  /* active tick */
        int inbt,outbt; /* input/output bytes at tick */
        // todo: Need to deal with this later
        // lock_t lock;        /* lock flag */
        // todo: Need to find proper type for port
        // void *port;         /* type dependent port control struct */
        char[] path = new char[MAXSTRPATH]; /* stream path */
        char[] msg = new char[MAXSTRMSG];  /* stream message */
    } ;

    public class strconv_t {        /* stream converter type */
        int itype,otype;    /* input and output stream type */
        int nmsg;           /* number of output messages */
        int[] msgs = new int[32];       /* output message types */
        double[] tint = new double[32];    /* output message intervals (s) */
        int[] tick = new int[32]; /* cycle tick of output message */
        int[] ephsat = new int[32];     /* satellites of output ephemeris */
        int stasel;         /* station info selection (0:remote,1:local) */
        rtcm_t rtcm;        /* rtcm input data buffer */
        raw_t raw;          /* raw  input data buffer */
        rtcm_t out;         /* rtcm output data buffer */
    } ;

    public class strsvr_t {        /* stream server type */
        int state;          /* server state (0:stop,1:running) */
        int cycle;          /* server cycle (ms) */
        int buffsize;       /* input/monitor buffer size (bytes) */
        int nmeacycle;      /* NMEA request cycle (ms) (0:no) */
        int relayback;      /* relay back of output streams (0:no) */
        int nstr;           /* number of streams (1 input + (nstr-1) outputs */
        int npb;            /* data length in peek buffer (bytes) */
        char[][] cmds_periodic = new char[16][MAXRCVCMD]; /* periodic commands */
        double[] nmeapos = new double[3];  /* NMEA request position (ecef) (m) */
        List<Byte> buff = new ArrayList<Byte>(); /* input buffers */
        List<Byte> pbuf = new ArrayList<Byte>(); /* peek buffer */
        long tick;  /* start tick */
        stream_t[] stream = new stream_t[16]; /* input/output streams */
        List<strconv_t[]> conv = new ArrayList<strconv_t[]>(); /* stream converter, conv[16] */
        // todo: I need to fix this later on
        // thread_t thread;    /* server thread */
        // lock_t lock;        /* lock flag */
    } ;

    public class rtksvr_t {        /* RTK server type */
        int state;          /* server state (0:stop,1:running) */
        int cycle;          /* processing cycle (ms) */
        int nmeacycle;      /* NMEA request cycle (ms) (0:no req) */
        int nmeareq;        /* NMEA request (0:no,1:nmeapos,2:single sol) */
        double[] nmeapos = new double[3];  /* NMEA request position (ecef) (m) */
        int buffsize;       /* input buffer size (bytes) */
        int[] format = new int[3];      /* input format {rov,base,corr} */
        solopt_t[] solopt = new solopt_t[2]; /* output solution options {sol1,sol2} */
        int navsel;         /* ephemeris select (0:all,1:rover,2:base,3:corr) */
        int nsbs;           /* number of sbas message */
        int nsol;           /* number of solution buffer */
        rtk_t rtk;          /* RTK control/result struct */
        int[] nb = new int[3];         /* bytes in input buffers {rov,base} */
        int[] nsb = new int[2];         /* bytes in soulution buffers */
        int[] npb = new int[3];         /* bytes in input peek buffers */
        List<byte[]> buff = new ArrayList<byte[]>(); /* input buffers {rov[3],base[3],corr[3]} */
        List<byte[]> sbuf = new ArrayList<byte[]>(); /* output buffers {sol1,sol2} */
        List<byte[]> pbuf = new ArrayList<byte[]>(); /* peek buffers {rov,base,corr} */
        sol_t[] solbuf = new sol_t[MAXSOLBUF]; /* solution buffer */
        long[][] nmsg = new long[3][10]; /* input message counts */
        raw_t[]  raw = new raw_t[3];     /* receiver raw control {rov,base,corr} */
        rtcm_t[] rtcm = new rtcm_t[3];     /* RTCM control {rov,base,corr} */
        gtime_t[] ftime = new gtime_t[3];   /* download time {rov,base,corr} */
        char[][] files = new char[3][MAXSTRPATH]; /* download paths {rov,base,corr} */
        obs_t[][] obs = new obs_t[3][MAXOBSBUF]; /* observation data {rov,base,corr} */
        nav_t nav;          /* navigation data */
        sbsmsg_t[] sbsmsg = new sbsmsg_t[MAXSBSMSG]; /* SBAS message buffer */
        stream_t[] stream = new stream_t[8]; /* streams {rov,base,corr,sol1,sol2,logr,logb,logc} */
        List<stream_t> moni = new ArrayList<stream_t>();     /* monitor stream */
        long tick;  /* start tick */
        // todo: Need to find equther icon
        //  ivalent thread in Java
        // thread_t thread;    /* server thread */
        int cputime;        /* CPU time (ms) for a processing cycle */
        int prcout;         /* missing observation data count */
        int nave;           /* number of averaging base pos */
        double[] rb_ave = new double[3];   /* averaging base pos */
        char[][] cmds_periodic = new char[3][MAXRCVCMD]; /* periodic commands */
        char[] cmd_reset = new char[MAXRCVCMD]; /* reset command */
        double bl_reset;    /* baseline length to reset (km) */
        // todo: Need to find equivalent locking systen in Java
        //lock_t lock;        /* lock flag */
    } ;

    public class gis_pnt_t {        /* gis data point type */
        double[] pos = new double[3];      /* point data {lat,lon,height} (rad,m) */
    } ;

    public class gis_poly_t {        /* gis data polyline type */
        int npnt;           /* number of points */
        double[] bound = new double[4];    /* boundary {lat0,lat1,lon0,lon1} */
        List<double[]> pos = new ArrayList<double[]>();        /* position data (3 x npnt) */
    } ;

    public class gis_polygon_t {        /* gis data polygon type */
        int npnt;           /* number of points */
        double[] bound = new double[4];    /* boundary {lat0,lat1,lon0,lon1} */
        List<double[]> pos = new ArrayList<double[]>();        /* position data (3 x npnt) */
    } ;

    public class gisd_t { /* gis data list type */
        int type;           /* data type (1:point,2:polyline,3:polygon) */
        // Need to find this data type
        // void *data;         /* data body */
        // todo: I think this is a linked struct
        gisd_t next; /* pointer to next */
    } ;

    public class gis_t {        /* gis type */
        char[][] name = new char[MAXGISLAYER][256]; /* name */
        int[] flag =  new int[MAXGISLAYER];     /* flag */
        List<gisd_t[]> data = new ArrayList<gisd_t[]>(); /* gis data list with internal array of [MAXGISLAYER] */
        double[] bound = new double[4];    /* boundary {lat0,lat1,lon0,lon1} */
    } ;

    public class imud_t {        /* imu data type */
        gtime_t time;       /* time */
        int stat;           /* status */
        int seqno;          /* sequence number */
        float temp;         /* temperature (C) */
        double[] rot = new double[3];      /* rotation rate {x,y,z} (rad/s) */
        double[] acc = new double[3];      /* acceleration data {x,y,z} (m/s^2) */
    } ;

    public class imu_t {        /* imu type */
        imud_t data;        /* imu data */
        int nbyte;          /* bytes in imu data buffer */
        byte[] buff = new byte[256]; /* imu data buffer */
    } ;
}
