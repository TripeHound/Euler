// vim:ai:ts=4:ic:aw:noet

import java.io.* ;

public class Euler_013 extends EulerBase
{
	public Euler_013()
	{
		title	= "Large sum" ;
		problem	= "Problem 13\n"
				+ "Published on 22 March 2002 at 06:00 pm [Server Time]\n"
				+ "\n"
				+ "Work out the first ten digits of the sum of the following one-hundred\n"
				+ "50-digit numbers.\n"
				+ "\n"
				+ "37107287533902102798797998220837590246510135740250\n"
				+ "46376937677490009712648124896970078050417018260538\n"
				+ "74324986199524741059474233309513058123726617309629\n"
				+ "91942213363574161572522430563301811072406154908250\n"
				+ "23067588207539346171171980310421047513778063246676\n"
				+ "89261670696623633820136378418383684178734361726757\n"
				+ "28112879812849979408065481931592621691275889832738\n"
				+ "44274228917432520321923589422876796487670272189318\n"
				+ "47451445736001306439091167216856844588711603153276\n"
				+ "70386486105843025439939619828917593665686757934951\n"
				+ "62176457141856560629502157223196586755079324193331\n"
				+ "64906352462741904929101432445813822663347944758178\n"
				+ "92575867718337217661963751590579239728245598838407\n"
				+ "58203565325359399008402633568948830189458628227828\n"
				+ "80181199384826282014278194139940567587151170094390\n"
				+ "35398664372827112653829987240784473053190104293586\n"
				+ "86515506006295864861532075273371959191420517255829\n"
				+ "71693888707715466499115593487603532921714970056938\n"
				+ "54370070576826684624621495650076471787294438377604\n"
				+ "53282654108756828443191190634694037855217779295145\n"
				+ "36123272525000296071075082563815656710885258350721\n"
				+ "45876576172410976447339110607218265236877223636045\n"
				+ "17423706905851860660448207621209813287860733969412\n"
				+ "81142660418086830619328460811191061556940512689692\n"
				+ "51934325451728388641918047049293215058642563049483\n"
				+ "62467221648435076201727918039944693004732956340691\n"
				+ "15732444386908125794514089057706229429197107928209\n"
				+ "55037687525678773091862540744969844508330393682126\n"
				+ "18336384825330154686196124348767681297534375946515\n"
				+ "80386287592878490201521685554828717201219257766954\n"
				+ "78182833757993103614740356856449095527097864797581\n"
				+ "16726320100436897842553539920931837441497806860984\n"
				+ "48403098129077791799088218795327364475675590848030\n"
				+ "87086987551392711854517078544161852424320693150332\n"
				+ "59959406895756536782107074926966537676326235447210\n"
				+ "69793950679652694742597709739166693763042633987085\n"
				+ "41052684708299085211399427365734116182760315001271\n"
				+ "65378607361501080857009149939512557028198746004375\n"
				+ "35829035317434717326932123578154982629742552737307\n"
				+ "94953759765105305946966067683156574377167401875275\n"
				+ "88902802571733229619176668713819931811048770190271\n"
				+ "25267680276078003013678680992525463401061632866526\n"
				+ "36270218540497705585629946580636237993140746255962\n"
				+ "24074486908231174977792365466257246923322810917141\n"
				+ "91430288197103288597806669760892938638285025333403\n"
				+ "34413065578016127815921815005561868836468420090470\n"
				+ "23053081172816430487623791969842487255036638784583\n"
				+ "11487696932154902810424020138335124462181441773470\n"
				+ "63783299490636259666498587618221225225512486764533\n"
				+ "67720186971698544312419572409913959008952310058822\n"
				+ "95548255300263520781532296796249481641953868218774\n"
				+ "76085327132285723110424803456124867697064507995236\n"
				+ "37774242535411291684276865538926205024910326572967\n"
				+ "23701913275725675285653248258265463092207058596522\n"
				+ "29798860272258331913126375147341994889534765745501\n"
				+ "18495701454879288984856827726077713721403798879715\n"
				+ "38298203783031473527721580348144513491373226651381\n"
				+ "34829543829199918180278916522431027392251122869539\n"
				+ "40957953066405232632538044100059654939159879593635\n"
				+ "29746152185502371307642255121183693803580388584903\n"
				+ "41698116222072977186158236678424689157993532961922\n"
				+ "62467957194401269043877107275048102390895523597457\n"
				+ "23189706772547915061505504953922979530901129967519\n"
				+ "86188088225875314529584099251203829009407770775672\n"
				+ "11306739708304724483816533873502340845647058077308\n"
				+ "82959174767140363198008187129011875491310547126581\n"
				+ "97623331044818386269515456334926366572897563400500\n"
				+ "42846280183517070527831839425882145521227251250327\n"
				+ "55121603546981200581762165212827652751691296897789\n"
				+ "32238195734329339946437501907836945765883352399886\n"
				+ "75506164965184775180738168837861091527357929701337\n"
				+ "62177842752192623401942399639168044983993173312731\n"
				+ "32924185707147349566916674687634660915035914677504\n"
				+ "99518671430235219628894890102423325116913619626622\n"
				+ "73267460800591547471830798392868535206946944540724\n"
				+ "76841822524674417161514036427982273348055556214818\n"
				+ "97142617910342598647204516893989422179826088076852\n"
				+ "87783646182799346313767754307809363333018982642090\n"
				+ "10848802521674670883215120185883543223812876952786\n"
				+ "71329612474782464538636993009049310363619763878039\n"
				+ "62184073572399794223406235393808339651327408011116\n"
				+ "66627891981488087797941876876144230030984490851411\n"
				+ "60661826293682836764744779239180335110989069790714\n"
				+ "85786944089552990653640447425576083659976645795096\n"
				+ "66024396409905389607120198219976047599490197230297\n"
				+ "64913982680032973156037120041377903785566085089252\n"
				+ "16730939319872750275468906903707539413042652315011\n"
				+ "94809377245048795150954100921645863754710598436791\n"
				+ "78639167021187492431995700641917969777599028300699\n"
				+ "15368713711936614952811305876380278410754449733078\n"
				+ "40789923115535562561142322423255033685442488917353\n"
				+ "44889911501440648020369068063960672322193204149535\n"
				+ "41503128880339536053299340368006977710650566631954\n"
				+ "81234880673210146739058568557934581403627822703280\n"
				+ "82616570773948327592232845941706525094512325230608\n"
				+ "22918802058777319719839450180888072429661980811197\n"
				+ "77158542502016545090413245809786882778948721859617\n"
				+ "72107838435069186155435662884062257473692284509516\n"
				+ "20849603980134001723930671666823555245252804609722\n"
				+ "53503534226472524250874054075591789781264330331690\n" ;
		runsets	= new RunSet[] {
					new RunSet( "Problem",	new Run( 10,	5537376230L ) )
				} ;
		report	= "The first %d digits of the mega-sum is %,d" ;
	}

//----------------------------------------------------------------------------------

	private static long[][] big_numbers = new long[][] {
		new long[] { 3710728753L,3902102798L,7979982208L,3759024651L, 135740250L },
		new long[] { 4637693767L,7490009712L,6481248969L,7007805041L,7018260538L },
		new long[] { 7432498619L,9524741059L,4742333095L,1305812372L,6617309629L },
		new long[] { 9194221336L,3574161572L,5224305633L, 181107240L,6154908250L },
		new long[] { 2306758820L,7539346171L,1719803104L,2104751377L,8063246676L },
		new long[] { 8926167069L,6623633820L,1363784183L,8368417873L,4361726757L },
		new long[] { 2811287981L,2849979408L, 654819315L,9262169127L,5889832738L },
		new long[] { 4427422891L,7432520321L,9235894228L,7679648767L, 272189318L },
		new long[] { 4745144573L,6001306439L, 911672168L,5684458871L,1603153276L },
		new long[] { 7038648610L,5843025439L,9396198289L,1759366568L,6757934951L },
		new long[] { 6217645714L,1856560629L,5021572231L,9658675507L,9324193331L },
		new long[] { 6490635246L,2741904929L,1014324458L,1382266334L,7944758178L },
		new long[] { 9257586771L,8337217661L,9637515905L,7923972824L,5598838407L },
		new long[] { 5820356532L,5359399008L,4026335689L,4883018945L,8628227828L },
		new long[] { 8018119938L,4826282014L,2781941399L,4056758715L,1170094390L },
		new long[] { 3539866437L,2827112653L,8299872407L,8447305319L, 104293586L },
		new long[] { 8651550600L,6295864861L,5320752733L,7195919142L, 517255829L },
		new long[] { 7169388870L,7715466499L,1155934876L, 353292171L,4970056938L },
		new long[] { 5437007057L,6826684624L,6214956500L,7647178729L,4438377604L },
		new long[] { 5328265410L,8756828443L,1911906346L,9403785521L,7779295145L },
		new long[] { 3612327252L,5000296071L, 750825638L,1565671088L,5258350721L },
		new long[] { 4587657617L,2410976447L,3391106072L,1826523687L,7223636045L },
		new long[] { 1742370690L,5851860660L,4482076212L, 981328786L, 733969412L },
		new long[] { 8114266041L,8086830619L,3284608111L,9106155694L, 512689692L },
		new long[] { 5193432545L,1728388641L,9180470492L,9321505864L,2563049483L },
		new long[] { 6246722164L,8435076201L,7279180399L,4469300473L,2956340691L },
		new long[] { 1573244438L,6908125794L,5140890577L, 622942919L,7107928209L },
		new long[] { 5503768752L,5678773091L,8625407449L,6984450833L, 393682126L },
		new long[] { 1833638482L,5330154686L,1961243487L,6768129753L,4375946515L },
		new long[] { 8038628759L,2878490201L,5216855548L,2871720121L,9257766954L },
		new long[] { 7818283375L,7993103614L,7403568564L,4909552709L,7864797581L },
		new long[] { 1672632010L, 436897842L,5535399209L,3183744149L,7806860984L },
		new long[] { 4840309812L,9077791799L, 882187953L,2736447567L,5590848030L },
		new long[] { 8708698755L,1392711854L,5170785441L,6185242432L, 693150332L },
		new long[] { 5995940689L,5756536782L,1070749269L,6653767632L,6235447210L },
		new long[] { 6979395067L,9652694742L,5977097391L,6669376304L,2633987085L },
		new long[] { 4105268470L,8299085211L,3994273657L,3411618276L, 315001271L },
		new long[] { 6537860736L,1501080857L,  91499395L,1255702819L,8746004375L },
		new long[] { 3582903531L,7434717326L,9321235781L,5498262974L,2552737307L },
		new long[] { 9495375976L,5105305946L,9660676831L,5657437716L,7401875275L },
		new long[] { 8890280257L,1733229619L,1766687138L,1993181104L,8770190271L },
		new long[] { 2526768027L,6078003013L,6786809925L,2546340106L,1632866526L },
		new long[] { 3627021854L, 497705585L,6299465806L,3623799314L, 746255962L },
		new long[] { 2407448690L,8231174977L,7923654662L,5724692332L,2810917141L },
		new long[] { 9143028819L,7103288597L,8066697608L,9293863828L,5025333403L },
		new long[] { 3441306557L,8016127815L,9218150055L,6186883646L,8420090470L },
		new long[] { 2305308117L,2816430487L,6237919698L,4248725503L,6638784583L },
		new long[] { 1148769693L,2154902810L,4240201383L,3512446218L,1441773470L },
		new long[] { 6378329949L, 636259666L,4985876182L,2122522551L,2486764533L },
		new long[] { 6772018697L,1698544312L,4195724099L,1395900895L,2310058822L },
		new long[] { 9554825530L, 263520781L,5322967962L,4948164195L,3868218774L },
		new long[] { 7608532713L,2285723110L,4248034561L,2486769706L,4507995236L },
		new long[] { 3777424253L,5411291684L,2768655389L,2620502491L, 326572967L },
		new long[] { 2370191327L,5725675285L,6532482582L,6546309220L,7058596522L },
		new long[] { 2979886027L,2258331913L,1263751473L,4199488953L,4765745501L },
		new long[] { 1849570145L,4879288984L,8568277260L,7771372140L,3798879715L },
		new long[] { 3829820378L,3031473527L,7215803481L,4451349137L,3226651381L },
		new long[] { 3482954382L,9199918180L,2789165224L,3102739225L,1122869539L },
		new long[] { 4095795306L,6405232632L,5380441000L,5965493915L,9879593635L },
		new long[] { 2974615218L,5502371307L,6422551211L,8369380358L, 388584903L },
		new long[] { 4169811622L,2072977186L,1582366784L,2468915799L,3532961922L },
		new long[] { 6246795719L,4401269043L,8771072750L,4810239089L,5523597457L },
		new long[] { 2318970677L,2547915061L,5055049539L,2297953090L,1129967519L },
		new long[] { 8618808822L,5875314529L,5840992512L, 382900940L,7770775672L },
		new long[] { 1130673970L,8304724483L,8165338735L, 234084564L,7058077308L },
		new long[] { 8295917476L,7140363198L,  81871290L,1187549131L, 547126581L },
		new long[] { 9762333104L,4818386269L,5154563349L,2636657289L,7563400500L },
		new long[] { 4284628018L,3517070527L,8318394258L,8214552122L,7251250327L },
		new long[] { 5512160354L,6981200581L,7621652128L,2765275169L,1296897789L },
		new long[] { 3223819573L,4329339946L,4375019078L,3694576588L,3352399886L },
		new long[] { 7550616496L,5184775180L,7381688378L,6109152735L,7929701337L },
		new long[] { 6217784275L,2192623401L,9423996391L,6804498399L,3173312731L },
		new long[] { 3292418570L,7147349566L,9166746876L,3466091503L,5914677504L },
		new long[] { 9951867143L, 235219628L,8948901024L,2332511691L,3619626622L },
		new long[] { 7326746080L, 591547471L,8307983928L,6853520694L,6944540724L },
		new long[] { 7684182252L,4674417161L,5140364279L,8227334805L,5556214818L },
		new long[] { 9714261791L, 342598647L,2045168939L,8942217982L,6088076852L },
		new long[] { 8778364618L,2799346313L,7677543078L, 936333301L,8982642090L },
		new long[] { 1084880252L,1674670883L,2151201858L,8354322381L,2876952786L },
		new long[] { 7132961247L,4782464538L,6369930090L,4931036361L,9763878039L },
		new long[] { 6218407357L,2399794223L,4062353938L, 833965132L,7408011116L },
		new long[] { 6662789198L,1488087797L,9418768761L,4423003098L,4490851411L },
		new long[] { 6066182629L,3682836764L,7447792391L,8033511098L,9069790714L },
		new long[] { 8578694408L,9552990653L,6404474255L,7608365997L,6645795096L },
		new long[] { 6602439640L,9905389607L,1201982199L,7604759949L, 197230297L },
		new long[] { 6491398268L,  32973156L, 371200413L,7790378556L,6085089252L },
		new long[] { 1673093931L,9872750275L,4689069037L, 753941304L,2652315011L },
		new long[] { 9480937724L,5048795150L,9541009216L,4586375471L, 598436791L },
		new long[] { 7863916702L,1187492431L,9957006419L,1796977759L,9028300699L },
		new long[] { 1536871371L,1936614952L,8113058763L,8027841075L,4449733078L },
		new long[] { 4078992311L,5535562561L,1423224232L,5503368544L,2488917353L },
		new long[] { 4488991150L,1440648020L,3690680639L,6067232219L,3204149535L },
		new long[] { 4150312888L, 339536053L,2993403680L, 697771065L, 566631954L },
		new long[] { 8123488067L,3210146739L, 585685579L,3458140362L,7822703280L },
		new long[] { 8261657077L,3948327592L,2328459417L, 652509451L,2325230608L },
		new long[] { 2291880205L,8777319719L,8394501808L,8807242966L,1980811197L },
		new long[] { 7715854250L,2016545090L,4132458097L,8688277894L,8721859617L },
		new long[] { 7210783843L,5069186155L,4356628840L,6225747369L,2284509516L },
		new long[] { 2084960398L, 134001723L,9306716668L,2355524525L,2804609722L },
		new long[] { 5350353422L,6472524250L,8740540755L,9178978126L,4330331690L }
	} ;

	private static StringBuilder total ;

	//	Split the mega-numbers into 10-digit chunks so they're easily contained
	//	within 'long's.  Then simply add things up starting from the last chunk,
	//	and keeping track of any carry.  The whole result is accumulated in a
	//	string, from which the first ten digits are taken.
	//
	protected long solve( long input )
		throws NoSolutionException
	{
		total = new StringBuilder( 60 ) ;
		final long TEN_BIL = 10000000000L ;

		long carry = 0 ;
		for( int part = 4 ; part >= 0 ; part-- )
		{
			for( int i=0 ; i < big_numbers.length ; i++ )
				carry += big_numbers[i][part] ;
			total.insert( 0, String.format( "%d", carry % TEN_BIL ) ) ;
			carry /= TEN_BIL ;
		}
		total.insert( 0, String.format( "%d", carry ) ) ;

		return Long.parseLong( total.substring( 0, 10 ) ) ;
	}

	protected String other_info()
	{
		return total.toString() ;
	}
}
