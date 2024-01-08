// lleaf <-> node <-> rleaf

// 			node
// 		/     \
// 	lleaf 	rleaf

// 						node
// 					/     \
// 			node			rleaf
// 		/     \
// 	lleaf 	rleaf

trait BT
case class Node(i: Int) extends BT
case class Leaf(lleaf : BT, node: BT, rleaf : BT) extends BT

// 3
val bt_case1 = Node(3)

			// 		3
			// 	/		\
			// 4			5
			// 			/		\
			// 		1				7
val bt_case2 = Leaf(Node(4), Node(3), Leaf(Node(1), Node(5), Node(7)))

def btSum (bt: BT) : Int = bt match
	case Node(i) => i
	case Leaf(lleaf, node, rleaf) => btSum(lleaf) + btSum(node) + btSum(rleaf)


def countNode(bt: BT) : Int = bt match
	case Node(_) => 1
	case Leaf(lleaf, node, rleaf) => countNode(lleaf) + countNode(node) + countNode(rleaf)


